package cn.itcast.hotel;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.service.impl.HotelService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
class HotelDemoApplicationTests {

    @Resource
    private RestHighLevelClient client;

    @Resource
    private HotelService hotelService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInit(){
        System.out.println(client);
    }

    @Test
    public void testAddDoc() throws IOException {
//      从数据库中查出来
        Hotel hotel = hotelService.getById(36934l);
//      转换成es中的index所对应的格式
        HotelDoc hotelDoc = new HotelDoc(hotel);
//      创建请求类，这个请求是发给hotel的
        IndexRequest request = new IndexRequest("hotel").id(hotel.getId().toString());
//      类转字符串，请求类加载资源
        request.source(JSON.toJSON(hotelDoc), XContentType.JSON);
//      发送请求
        client.index(request, RequestOptions.DEFAULT);
    }

}
