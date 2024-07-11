package lk.ijse.util;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Paint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean isTextFieldValid(TextField textField,String text){
        String field =" ";

        switch (textField) {
            case  COLLECT_ID:
                field = "^([A-Z][0-9]{3})$";
                break;
            case TS_ID:
                field ="^([A-Z][0-9]{3})$";
                break;
            case EMP_ID:
                field ="^([A-Z][0-9]{3})$ ";
                break;
            case ITEMID:
                field ="^([A-Z][0-9]{3})$";
                break;
            case ORDERID:
                field ="^([A-Z][0-9]{3})$";
                break;
            case PAYID:
                field ="^([A-Z][0-9]{3})$";
                break;
            case TEAID:
                field ="^([A-Z][0-9]{3})$";
                break;
            case CODE:
                field ="^([0-9]{4})$";
                break;
            case NAME:
                field ="^[A-z|\\\\s]{3,}$";
                break;
            case ADDRESS:
                field ="^([A-z0-9]|[-/,.@+]|\\\\s){4,}$";
                break;
            case CONTACT:
                field ="^([+]94{1,3}|[0])([1-9]{2})([0-9]){7}$";
                break;
            case TS_NAME:
                field ="^[A-z|\\\\s]{3,}$";
                break;
            case TS_ADDRESS:
                field ="^([A-z0-9]|[-/,.@+]|\\\\s){4,}$";
                break;
            case TS_CONTACT:
                field ="^([+]94{1,3}|[0])([1-9]{2})([0-9]){7}$";
                break;
            case DATE:
                field ="\\d{1,2}\\/\\d{1,2}\\/\\d{2,4}\n";
                break;
            case DESCRIPTION:
                field ="^([A-z|\\\\s]{4,})$";
                break;
            case DURATION:
                field ="^([\\\\d]{3}|[\\\\d]{2}|[\\\\d]{1})$";
                break;
            case SALARY:
                field ="^([0-9]){1,}[.]([0-9]){1,}$";
                break;
            case QUANTITY:
                field ="^([\\\\d]{3}|[\\\\d]{2}|[\\\\d]{1})$";
                break;
            case CATEGORY:
                field ="^[A-z|\\\\s]{3,}$";
                break;
            case PAYMETHOD:
                field ="^[A-z|\\\\s]{3,}$";
                break;
            case PRICE:
                field ="^([0-9]){1,}[.]([0-9]){1,}$";
                break;
            case KGPRICE:
                field ="^([0-9]){1,}[.]([0-9]){1,}$";
                break;
            default:
                System.out.println("Completed");

        }
        Pattern pattern = Pattern.compile(field);

        if (text != null){
            if (text.trim().isEmpty()){
                return false;
            }
        }else {
            return false;
        }

        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()){
            return true;
        }
        return false;
    }
    public static boolean setTextColor(TextField location, JFXTextField field){
        if (Regex.isTextFieldValid(location,field.getText())){
            field.setFocusColor(Paint.valueOf("Green"));
            field.setUnFocusColor(Paint.valueOf("Green"));
            return true;
        }else {
            field.setFocusColor(Paint.valueOf("Red"));
            field.setUnFocusColor(Paint.valueOf("Red"));
            return false;
        }
    }
    public static boolean setTextColor(TextField location, JFXPasswordField field){
        if (Regex.isTextFieldValid(location,field.getText())){
            field.setFocusColor(Paint.valueOf("Green"));
            field.setUnFocusColor(Paint.valueOf("Green"));
            return true;
        }else {
            field.setFocusColor(Paint.valueOf("Red"));
            field.setUnFocusColor(Paint.valueOf("Red"));
            return false;
        }
    }

    }


