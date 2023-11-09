## 文档说明：
这是小组成员文件夹：(AiXu)
> 此文件夹同于存放，小组成员的每日代码，这里写了，一个demo可以
> 按照此目录结构来建立，当然也可以按照自己习惯来，
> 
> 要求：只能更改自己的文件下的代码，提交的时候一定要注意，避免给别人带来麻烦
> 
> **强调** 提交代码注意检查!!!
> 
> **强调** 提交代码注意检查!!!
>
> **强调** 提交代码注意检查!!!


文件格式：
> 姓名拼音 && 首字母大写

文件需要带上自己的文档注释如：
```java
/**
 * 文件工具类
 *
 * @author aixu
 * @since 2023/11/2
 */
public class FliesUtil {
    // 成员变量：获取数据集合
    private static List<String> stringList = new ArrayList<>();
    
    // 方法注释
    /**
     * 创建递归查找文件操作
     *
     * @param file       查找文件路径
     * @param suffixName 文件后缀名
     * @return 返回按条件查询的目录+文件名                 
     */
    public static List<String> findFolder(File file, String suffixName) {
        // 递归结束条件
        if (!file.exists()) return null;

        // 如果是目录，请进入内部并递归调用
        if (file.isDirectory()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                // 进行查找条件
                findFolder(listFile, suffixName);
            }
        }
        // 查找,代suffixName的文件
        if (file.getName().endsWith(suffixName)){
            stringList.add(file.getAbsolutePath());
        }
        return stringList;
    }

    /**
     * 复制文件
     * @param in 输入文件
     * @param out 输出文件
     */
    public static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            // write(byte[] b)
            // 读了多个个字节 写多少个
            out.write(bytes,0,readCount);
        }

    }
}


```