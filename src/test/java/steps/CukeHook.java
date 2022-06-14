package steps;

import cucumber.api.java.Before;

public class CukeHook {

    @Before
    public void abc(){
        System.out.println("DARI");
    }


}
