##### Base-Core 核心包

##### BaseController<服务类接口,数据库实体类>
作用:减少基本的增删改查分页查询
```java
@RestController
@RequestMapping("/tAvgleVideo")
public class TAvgleVideoController extends BaseController<ITAvgleVideoService, TAvgleVideo> {

}
```
其中包含分页查询如:
```java
url http://localhost:8080/tAvgleVideo/list
requestBody {"page":1,"limit":10,"params":[{"column":"id","type":"rightlike","value":99},{"column":"title","type":"like","value":"田"}]} 
```