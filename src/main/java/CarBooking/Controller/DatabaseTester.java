package CarBooking.Controller;

import CarBooking.Model.PaymentType;
import CarBooking.Model.State;
import CarBooking.Model.User;
import CarBooking.Model.dao.DBConnector;
import CarBooking.Model.dao.PaymentTypeDBManager;
import CarBooking.Model.dao.UserDBManager;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseTester {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {



        ArrayList<State> states = new ArrayList<State>();
        states.add(new State(1, "NSW"));
        states.add(new State(2, "QLD"));
        states.add(new State(3, "NSA"));
        Gson gson = new Gson();
        String json = gson.toJson(states);
        System.out.println(json);
//        response.getWriter().write(json);


    }

}