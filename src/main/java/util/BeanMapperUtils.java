package util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**  
 * @author yuanjj
 * @version 1.0
 */

public class BeanMapperUtils {
	private static Mapper mapper = new DozerBeanMapper();;
	

    public static <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationClass);
    }

    public static void map(Object source, Object destination) {
    	mapper.map(source, destination);
    }

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            destinationList.add(mapper.map(sourceObject, destinationClass));
        }
        return destinationList;
    }
}
