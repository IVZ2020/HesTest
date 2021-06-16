package test.hes.demo.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateService {

    public String getCurrentDate () {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        return dateFormat.format(currentDate);
    }
}

