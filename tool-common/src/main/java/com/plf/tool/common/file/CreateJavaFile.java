package com.plf.tool.common.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 新建Java文件
 */
public class CreateJavaFile {

    public void test() throws IOException, ClassNotFoundException {
		/*List<String> list = getClassByPackageName("com.bean");
		System.out.println(list);

		for (String string : list) {
			List<Field> fields = getAllFields(Class.forName(string));
			System.out.println(fields);
		}*/

        writeFile("package com.service;\n\n"
                + "public class HelloWorld{\n\n"
                + "\tpublic static void main(String[] args){\n"
                + "\t\tSystem.out.println(\"Hello World\");\n"
                + "\t}\n"
                + "}",null,null);
        //System.out.println(this.getClass().getResource("").getPath());
        //System.out.println(new File("").getCanonicalPath());
    }

    public static Map<String, Object> getClassInfo(String className) {
        Map<String, Object> map = new HashMap<>();
        try {
            Class<?> clazz = Class.forName(className);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                System.out.println("方法名称:" + methodName);
                map.put("methodName", methodName);
                Class<?>[] parameterTypes = method.getParameterTypes();
                List<String> list = new ArrayList<>();
                for (Class<?> clas : parameterTypes) {
                    String parameterName = clas.getName();
                    list.add(parameterName);
                    System.out.println("参数类型:" + parameterName);
                }
                map.put("parameterName", list);
                Class<?> returnType = method.getReturnType();
                map.put("returnName", returnType.getName());
                System.out.println("返回类型:" + returnType.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return map;

    }

    public static List<Field> getAllFields(Class<?> clazz) {
        List<Field> list = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        Collections.addAll(list, fields);
        return list;
    }

    public static List<String> getClassByPackageName(String packageName) {
        List<String> result = new ArrayList<>();
        Enumeration<URL> dirs = null;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageName.replace(".", "/"));
            // 迭代此Enumeration
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                File file = new File(url.getFile());
                // 把目录下的所有文件列出
                String[] classes = file.list();
                assert classes != null;
                for (String className : classes) {
                    className = className.substring(0, className.length() - 6);
                    String realName = packageName + "." + className;
                    result.add(realName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static void writeFile(String content, String packageName, String className) throws IOException {
        File file = new File(new File("").getCanonicalPath()+"\\src\\main\\java\\com\\service\\HelloWorld.java");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fwriter = null;
        try {

            fwriter = new FileWriter(new File("").getCanonicalPath()+"\\src\\main\\java\\com\\service\\HelloWorld.java");
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                assert fwriter != null;
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
