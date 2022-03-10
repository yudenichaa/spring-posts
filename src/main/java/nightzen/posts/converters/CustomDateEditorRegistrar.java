package nightzen.posts.converters;

//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Component
//public class StringToDate implements Converter<String, Date> {
//
//    public Date convert(String source) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            return dateFormat.parse(source);
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//
//}

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;

@Component
public class CustomDateEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), false));
    }
}
