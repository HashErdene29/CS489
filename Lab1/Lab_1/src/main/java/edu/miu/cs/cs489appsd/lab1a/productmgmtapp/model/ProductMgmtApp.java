package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class ProductMgmtApp {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55f));
        productList.add(new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09f));
        productList.add(new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99f));

        Collections.sort(productList, Comparator.comparing(Product::getName));

        printProducts(productList);

    }

    public static void printProducts(List<Product> productList) {
        System.out.println("Printed in JSON format");
        System.out.println("[");
        JSONArray jsonArray = new JSONArray(productList);
        for(int i =0; i < jsonArray.length(); i++){
            System.out.printf("\t" + "{  ");
            JSONObject innerobj = jsonArray.getJSONObject(i);
            for(Iterator it = innerobj.keys(); it.hasNext(); ){
                String key = (String) it.next();
                System.out.printf("'" + key + "'" + ":" + innerobj.get(key) + ",  ");
            }
            System.out.println("  }" );
        }
        System.out.println("]");
        System.out.println("--------------------------------------------");

        System.out.println("Printed in XML format");
        Element rootElement = new Element("products");
        Document document = new Document(rootElement);

        for(Product p: productList){
            Element productElement = new Element("product");
            productElement.setAttribute("productId", String.valueOf(p.getProductId()));
            productElement.setAttribute("name", p.getName());
            productElement.setAttribute("dateSupplied", p.getDateSupplied());
            productElement.setAttribute("quantityInStock", String.valueOf(p.getQuantityInStock()));
            productElement.setAttribute("unitPrice", String.valueOf(p.getUnitPrice()));
            rootElement.addContent(productElement);
        }

        XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());

        System.out.println( xmlOutput.outputString(document));
        System.out.println("--------------------------------------------");

        System.out.println("Printed in Comma-Separated Value(CSV) format");
        for(Product p: productList){
            System.out.println(p.getProductId() + ", " + p.getName() + ", " + p.getDateSupplied() + ", " + p.getQuantityInStock() + ", " + p.getUnitPrice());
        }
    }

}
