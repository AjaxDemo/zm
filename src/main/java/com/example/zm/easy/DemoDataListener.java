package com.example.zm.easy;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.zm.entity.UserInfo;
import com.example.zm.entity.UserInfoDTO;
import com.example.zm.mapper.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.example.zm.util.BeanMapperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author:zm
 * @since 2020/10/23 10:30
 */
@Repository
public class DemoDataListener extends AnalysisEventListener<UserInfoDTO> {
    private UserInfoMapper userInfoMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 2000;
    List<UserInfoDTO> list = new ArrayList<UserInfoDTO>();

    public DemoDataListener(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }
    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData(list);
        LOGGER.info("所有数据解析完成！");
    }
    /**
     * 加上存储数据库
     */
    private void saveData(List<UserInfoDTO> list ) {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        List<UserInfo> userInfos = BeanMapperUtils.mapList(list, UserInfo.class);
        for (int i = 0; i <userInfos.size(); i++) {
            UserInfo userInfo = userInfos.get(i);
            userInfo.setId(UUID.randomUUID().toString());
            userInfoMapper.insert(userInfo);
        }
        LOGGER.info("存储数据库成功！");
    }

    @Override
    public void invoke(UserInfoDTO dto, AnalysisContext analysisContext) {
//        LOGGER.info("解析到一条数据:{}", userInfo);
        list.add(dto);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData(list);
            // 存储完成清理 list
            list.clear();
        }
    }
//test
}
