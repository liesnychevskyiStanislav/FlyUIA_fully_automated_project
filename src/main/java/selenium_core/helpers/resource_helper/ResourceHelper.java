package selenium_core.helpers.resource_helper;

public class ResourceHelper // method helps to reduce paths for files
{
    // Path to project properties
    //----------------------------------------------------------------------------------------------------------------||
    public static String getRecoursePath(String path)
    {
        String basePath = System.getProperty("user.dir"); // give us project-path
        return basePath + "\\" + path; // + path some file or class
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void main(String[] args)
    {
        String path = ResourceHelper.getRecoursePath("src\\main\\resources\\config.properties");
        System.out.println(path);
    }
}
