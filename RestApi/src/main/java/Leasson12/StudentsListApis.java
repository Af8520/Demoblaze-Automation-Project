package Leasson12;

//public class StudentsListApis {
//    private final String baseURL = "http://localhost:9000";
//    private Response response;
//    private JsonPath jp;
//    private RequestSpecification request;
//
//    @BeforeClass
//    public void start() {
//        RestAssured.baseURI = baseURL;
//        request = RestAssured.given();
//        request.header("Content-Type", "application/json");
//    }

//    @Test
//    public void test01GET() {
//        response = request.get("/student/list");
//        jp=response.jsonPath();
//        List<String> firstName=jp.getList("firstName");
//        List<String> lastName=jp.getList("lastName");
//        List<String> email=jp.getList("email");
//        for (int i=0;i<firstName.size();i++){
//            System.out.println("firstName:" +firstName.get(i) +"lastName:" +lastName.get(i)+"email:" +email.get(i));
//        }
//
//    }


//    @Test
//    public void test02POST() {
//        JSONObject params = new JSONObject();
//        params.put("firstName", "Alon");
//        params.put("lastName", "Fiban");
//        params.put("email", "AF@GMAIL.COM");
//        params.put("programme", "QA Engineering");
//
////        request.body(params.toJSONString());
////        response = request.post("/student");
////
////        Assert.assertEquals(response.getStatusCode(), 201);
//
//
//    }

//    @Test
//    public void test02_PUT_Course() {
//
//        JSONObject params = new JSONObject();
//        params.put("firstName", "Alon");
//        params.put("lastName", "Fiban");
//        params.put("email", "AF@GMAIL.COM");
//        params.put("programme", "QA Engineering");
//        params.put("courses", Arrays.asList("JAVA","PYTHON","WEB"));
//
//        request.body(params.toJSONString());
//        response = request.put("/student/104");
//        response.prettyPrint();
//
//
//        System.out.println(response.statusCode());
//        System.out.println(response.getBody().asString());
//        Assert.assertEquals(response.statusCode(), 200);
//
//
//    }
//    @Test
//    public void test04DELETE(){
//        response=request.delete("/student/104");
//        response.prettyPrint();
//        Assert.assertEquals(response.statusCode(),204);
//    }


