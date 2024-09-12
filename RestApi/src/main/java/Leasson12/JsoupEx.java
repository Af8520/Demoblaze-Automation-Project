package Leasson12;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class JsoupEx {

    Document doc;
    String expectedTitle="Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
    final String pixWidth="250";
    final String pixHeight="200";
    final String expectedCat="All Categories";
    @BeforeClass
    public void startSession() throws IOException {
        doc= Jsoup.connect("https://www.ebay.com/").get();

    }
    @Test
    public void test01VerifyEbayTitle(){
        String actualTitle=doc.title();
        System.out.println("actual title is:"+actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void test02VerifyEbayPixWidth(){
        Assert.assertEquals(doc.getElementById("gh-logo").attr("width"),pixWidth);

    }
    @Test
    public void test02VerifyEbayPixHeight(){
        Assert.assertEquals(doc.getElementById("gh-logo").attr("height"),pixHeight);

    }
    @Test
    public void test03VerifyAllCategories(){
//        option01

        Element categoryEle=doc.getElementById("gh-cat-box");
        String actualCategory=categoryEle.text();
        System.out.println("actual cat is:"+ actualCategory);
        Assert.assertEquals(actualCategory,expectedCat);

//        option02

//        Assert.assertEquals(doc.getElementsByAttributeValue("id", "gh-cat").get(0).text(), expectedCat);


    }


}
