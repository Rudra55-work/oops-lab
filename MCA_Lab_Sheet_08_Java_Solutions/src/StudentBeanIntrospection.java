import java.beans.*;
import java.lang.reflect.Method;

public class StudentBeanIntrospection {
    public static void main(String[] args) throws Exception {
        BeanInfo info = Introspector.getBeanInfo(StudentBean.class, Object.class);
        System.out.println("Properties:");
        for (PropertyDescriptor p : info.getPropertyDescriptors()) {
            System.out.println(p.getName() + " | type=" + p.getPropertyType().getSimpleName() +
                " | getter=" + p.getReadMethod() + " | setter=" + p.getWriteMethod());
        }
        System.out.println("\\nMethods:");
        for (Method m : StudentBean.class.getDeclaredMethods()) System.out.println(m);
    }
}
