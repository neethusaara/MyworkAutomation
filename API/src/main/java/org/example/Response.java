package org.example;

import Files.payloadfile;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Response {

    @Test
    public void SumValidation()
    {
        JsonPath jsn = new JsonPath(payloadfile.dummy());

        //To print the number of courses

        int count = jsn.getInt("courses.size()");  //This only print if courses is in array ( json will consider [] as array
        System.out.println(count);

        //Total purchase amount

        int amount = jsn.getInt("dashboard.purchaseAmount");
        System.out.println("purchase amount = "+amount);

        //print title of first course

        String firstCourse = jsn.getString("courses[0].title");
        System.out.println("first course title = "+firstCourse);

        //print all course  title and price

        for (int i=0;i<count;i++)
        {
            String title = jsn.get("courses["+i+"].title");
            System.out.println(title);
            int price = jsn.getInt("courses["+i+"].price");
            System.out.println(price);
        }

        //print copies sold for RPA course

        for (int j= 0; j<count;j++)
        {
            String titles= jsn.get("courses["+j+"].title");
            if(titles.contains("RPA"))
            {
                int copiesSold = jsn.get("courses["+j+"].copies");
                System.out.println("copies sold = "+copiesSold);
                break;
            }
        }
//sum of all course matches with total purchase amount
        int totalprice = 0;
        for (int k= 0; k<count;k++) {
            int price = jsn.getInt("courses[" + k + "].price");
            int count1 = jsn.getInt("courses[" + k + "].copies");
            int amountfor1course = price * count1;
            totalprice = totalprice + amountfor1course;
        }
        System.out.println("sum of total price for each course = "+totalprice);
        Assert.assertEquals(amount,totalprice);

        }

}
