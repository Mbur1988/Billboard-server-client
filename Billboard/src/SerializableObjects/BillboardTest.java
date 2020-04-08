package SerializableObjects;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 ******************* This is the test class for the Billboards**********
 * before each the tester will create a new billboard  using the constructor with...
 * (String msg, String info, String picURL, String picDATA, String MsgColour,String BackColour, String InfoColour)
 * Test 1 to 7 are to test if all fields have been filled - consider adding more for other constructors made ase we go. (uses underTestFull)
 * Test 8-**** are for inserting then reading each field using their functions. (uses underTestEmpty)
 * as this continues we will add functionality to display image etc
 */

public class BillboardTest {
    Billboard underTestEmpty;
    Billboard underTestFull;

    @BeforeEach @Test
    // Billboard = newBillboard(String msg, String info, String picURL, String picDATA, String MsgColour,String BackColour, String InfoColour)
    void newBillboard() {
          underTestFull = new Billboard("TEST MsG","TEST INFO","https://dazedimg-dazedgroup.netdna-ssl.com/830/azure/dazed-prod/1150/0/1150228.jpg",
                 "TEST","#000000","#FFFFFF","#000000");
        underTestEmpty = new Billboard();

    }

    /**
     *
     * Test 1,
     *      Check if msg has been inserted
     * @throws Exception
     */
    @Test
    public void MessageInserted () throws Exception{
        //uses getMsg funct
        assertEquals(underTestFull.getMsg(),"TEST MsG");
    }


    /**
     *
     * Test 2,
     *      Check if info has been inserted
     * @throws Exception
     */
    @Test
    public void InfoInserted () throws Exception{
        //uses getInfo func
        assertEquals(underTestFull.getInfo(),"TEST INFO");
    }
    /**
     *
     * Test 3,
     *      Check if picURL has been inserted
     * @throws Exception
     */
    @Test
    public void picURLInserted () throws Exception{
        //uses getPicUrl func
        assertEquals(underTestFull.getPicUrl(),"https://dazedimg-dazedgroup.netdna-ssl.com/830/azure/dazed-prod/1150/0/1150228.jpg");
    }
    /**
     *
     * Test 4,
     *      Check if PicData has been inserted
     * @throws Exception
     */
    @Test
    public void PicDataInserted () throws Exception{
        //uses getPicData func
        assertEquals(underTestFull.getPicData(),"TEST");
    }
    /**
     *
     * Test 5,
     *      Check if Message colour has been inserted
     * @throws Exception
     */
    @Test
    public void MsgColourInserted () throws Exception{
        //uses getMsgColour func
        assertEquals( underTestFull.getMsgColour(),"#000000");
    }
    /**
     *
     * Test 6,
     *      Check if BackColour has been inserted
     * @throws Exception
     */
    @Test
    public void BackColourInserted () throws Exception{
        //uses getBackColour func
        assertEquals(underTestFull.getBackColour(),"#FFFFFF");
    }
    /**
     *
     * Test 7,
     *      Check if info colour has been inserted
     * @throws Exception
     */
    @Test
    public void InfoColourInserted () throws Exception{
        //uses getInfoColour func
        assertEquals(underTestFull.getInfoColour(),"#000000");
    }

    /**
     *
     * Test 8,
     *      Check if empty constructor has left msg null
     * @throws Exception
     */
    @Test
    public void EmptyMsgCheck () throws Exception{
        //uses getMsg func
        assertNull(underTestEmpty.getPicUrl());
    }

    /**
     * Test 9,
     *      Checks if set msg funct is setting a new function over the OG
     * @throws Exception
     */
    @Test
    public void EmptyMsgInsert () throws Exception {
        //uses setMsg funct
        underTestEmpty.setMsg("Test 9");
        assertEquals(underTestEmpty.getMsg(),"Test 9");
    }
    /**
     *
     * Test 10,
     *      Check if empty constructor has left info null
     * @throws Exception
     */
    @Test
    public void EmptyinfoCheck () throws Exception{
        //uses getMsg func
        assertNull(underTestEmpty.getPicUrl());
    }

    /**
     * Test 11,
     *      Checks if set info funct is setting a new function over the OG
     * @throws Exception
     */
    @Test
    public void EmptyInfoInsert () throws Exception {
        //uses setMsg funct
        underTestEmpty.setInfo("Test 11");
        assertEquals(underTestEmpty.getInfo(),"Test 11");
    }
    /**
     *
     * Test 12,
     *      Check if empty constructor has left pic URL null
     * @throws Exception
     */
    @Test
    public void EmptyURLCheck () throws Exception{
        //uses getPicUrl func
        assertNull(underTestEmpty.getPicUrl());
    }

    /**
     * Test 13,
     *      Checks if set pic URL funct is setting a new function over the OG
     * @throws Exception
     */
    @Test
    public void EmptyURLInsert () throws Exception {
        //uses setPicUrl funct
        underTestEmpty.setPicURL("Test 13");
        assertEquals(underTestEmpty.getPicUrl(),"Test 13");
    }
    /**
     *
     * Test 14,
     *      Check if empty constructor has left pic DATA null
     * @throws Exception
     */
    @Test
    public void EmptyDataCheck () throws Exception{
        //uses getPicData func
        assertNull(underTestEmpty.getPicUrl());
    }

    /**
     * Test 15,
     *      Checks if set pic Data funct is setting a new function over the OG
     * @throws Exception
     */
    @Test
    public void EmptyDataInsert () throws Exception {
        //uses setPicData funct
        underTestEmpty.setPicData("Test 15");
        assertEquals(underTestEmpty.getPicData(),"Test 15");
    }
    /**
     *
     * Test 16,
     *      Check if empty constructor has left msg Colour null
     * @throws Exception
     */
    @Test
    public void EmptyMsgColourCheck () throws Exception{
        //uses getMsgColour func
        assertNull(underTestEmpty.getPicUrl());
    }

    /**
     * Test 17,
     *      Checks if set msg colour funct is setting a new function over the OG
     * @throws Exception
     */
    @Test
    public void EmptyMsgColourInsert () throws Exception {
        //uses setMsgColour funct
        underTestEmpty.setMsgColour("Test 17");
        assertEquals(underTestEmpty.getMsgColour(),"Test 17");
    }
    /**
     *
     * Test 18,
     *      Check if empty constructor has left back Colour null
     * @throws Exception
     */
    @Test
    public void EmptyBackColourCheck () throws Exception{
        //uses getBackColour func
        assertNull(underTestEmpty.getPicUrl());
    }

    /**
     * Test 19,
     *      Checks if set back colour funct is setting a new function over the OG
     * @throws Exception
     */
    @Test
    public void EmptyBackColourInsert () throws Exception {
        //uses setBackColour funct
        underTestEmpty.setBackColour("Test 19");
        assertEquals(underTestEmpty.getBackColour(),"Test 19");
    }
    /**
     *
     * Test 20,
     *      Check if empty constructor has left info Colour null
     * @throws Exception
     */
    @Test
    public void EmptyInfoColourCheck () throws Exception{
        //uses getInfoColour func
        assertNull(underTestEmpty.getPicUrl());
    }

    /**
     * Test 21,
     *      Checks if set info colour funct is setting a new function over the OG
     * @throws Exception
     */
    @Test
    public void EmptyInfoColourInsert () throws Exception {
        //uses setInfoColour funct
        underTestEmpty.setInfoColour("Test 21");
        assertEquals(underTestEmpty.getInfoColour(),"Test 21");
    }





}
