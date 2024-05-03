package Store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Server extends Person{

    private String ssn;

    public Server(String name, String phone, String ssn) {
        super(name, phone);
        this.ssn=ssn;
    }

    public Server(BufferedReader in) throws IOException {
        super(in);
    }
    @Override
    public void save(BufferedWriter out) throws IOException {
        out.write(ssn + '\n');
        super.save(out);
    }
}

