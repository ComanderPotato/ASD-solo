package CarBooking.Controller;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class JsonBuilder<E> {
    public JsonBuilder() {}
    public String getJsonObject(ArrayList<E> array) {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create().toJson(array);
    }
}