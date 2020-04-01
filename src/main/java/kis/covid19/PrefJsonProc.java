/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kis.covid19;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author naoki
 */
public class PrefJsonProc {
    static void writeJson(LocalDate date, Map<String, Integer> prefs) throws IOException {
        try (var pw = new PrintWriter("data/prefs%s.json".formatted(date), "UTF-8")) {
            pw.print("""
                       {
                         "lastupdate":"%s",
                         "prefList": [
                       """.formatted(date));
            prefs.forEach((pref, patients) -> pw.print(
                       """
                           {
                             "pref": "%s",
                             "patients": %d
                           },
                       """.formatted(pref, patients)));
            pw.print("""
                           {
                             "pref": "_",
                             "patients": 0
                           }
                         ]
                       }
                       """);
            
        }        
    }
}
