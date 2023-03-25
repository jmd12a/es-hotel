package cn.itcast.hotel.constant;

/**
 * @author Jmd
 * @create 2023-03-2023/3/24-20:10
 * @Description：
 */
public class RequestConstant {

    public static String index = "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\": {\n" +
            "        \"type\":\"keyword\"\n" +
            "      },\n" +
            "      \"name\": {\n" +
            "        \"type\": \"text\"\n" +
            "        , \"analyzer\": \"ik_smart\"\n" +
            "        , \"copy_to\": \"{all}\"\n" +
            "      },\n" +
            "      \"address\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "        , \"index\": false\n" +
            "      },\n" +
            "      \"price\": {\n" +
            "        \"type\": \"double\"\n" +
            "        , \"copy_to\": \"{all}\"\n" +
            "      },\n" +
            "      \"score\": {\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"brand\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"city\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"start_name\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"business\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "        , \"copy_to\": \"{all}\"\n" +
            "      },\n" +
            "      \"location\": {\n" +
            "        \"type\": \"geo_point\"\n" +
            "      },\n" +
            "      \"pic\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "        , \"index\": false\n" +
            "      },\n" +
            "      \"all\": {\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
