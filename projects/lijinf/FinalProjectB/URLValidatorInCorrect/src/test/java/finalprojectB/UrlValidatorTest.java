
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


    public UrlValidatorTest(String testName) {
        super(testName);
    }


    public void testManualTest() {
        System.out.println("manual test");
        UrlValidator URL = new UrlValidator();
        UrlValidator urlVal = new UrlValidator(null);
        assertTrue(urlVal.isValid("http://www.google.com"));
        assertTrue(urlVal.isValid("http://www.google.com/"));
        assertTrue(urlVal.isValid("http://1.2.3.4"));
        assertFalse(urlVal.isValid("http//www.google.com"));
        assertFalse(urlVal.isValid("hp://www.google.com"));
    }


    public void testYourFirstPartition() {
        //testing scheme part
        System.out.println("testing scheme");
        UrlValidator URL = new UrlValidator();
        String[] Schemes = {"http", "https", "ftp", "smb", "dns", "smtp"};
        String[] validSchemes = {"http", "https", "ftp", "dns", "smtp"};
        UrlValidator urlVal = new UrlValidator(Schemes, 0);
        System.out.println("valid test");
        for (int i = 0; i < 5; i++) {
            String temp = validSchemes[i] + "://www.google.com";
            System.out.println("i: " + i);
            System.out.println(temp);
            assertTrue(urlVal.isValid(temp));
        }
    }

    public void testYourSecondPartition() {
        //testing port part
        System.out.println("testing port");
        UrlValidator URL = new UrlValidator();
        String[] validAuth = {"www.google.com", "go.com", "1.1.1.1", "255.com", "sina.cn"};
        UrlValidator urlVal = new UrlValidator(null, null, URL.ALLOW_ALL_SCHEMES);
        System.out.println("valid test");
        for (int i = 0; i < 5; i++) {
            String temp = "https://" + validAuth[i];
            System.out.println("i: " + i);
            assertTrue(urlVal.isValid(temp));
        }
    }
    //You need to create more test cases for your Partitions if you need to

    public void testIsValid() {
        //You can use this function for programming based testing
        UrlValidator URL = new UrlValidator();
        UrlValidator urlVal = new UrlValidator(null, null, URL.ALLOW_ALL_SCHEMES);
        String[] validSchemes = {"http://", "https://", "ftp://", "h3t://"};
        String[] inValidSchemes = {"htp://", "http:/", "https:", "hp//", "://"};
        String[] validAuth = {"www.google.com", "go.com", "1.1.1.1", "255.com", "sina.cn"};
        String[] inValidAuth = {"go.a", "abc", "256.256.256.256", "", "google."};
        String[] validPort = {":80",":0","",":65535",""};
        String[] inValidPort = {":80b",":a",":-1",":65536",":-"};
        String[] validPath = {"/test","/test6","/test/","/test/test2","/$10",""};
        String[] inValidPath = {"/..","/../","/..//test","/./","//t","/t//abc"};

        System.out.println("valid test");
        for(int scheme=0;scheme<validSchemes.length;scheme++){
            for(int auth=0;auth<validAuth.length;auth++){
                for(int port=0;port<validPort.length;port++){
                    for(int path=0;path<validPath.length;path++){
                        String testcase = validSchemes[scheme] + validAuth[auth] + validPort[port] + validPath[path];
                        System.out.println(testcase + "      True");
                        assertTrue(urlVal.isValid(testcase));
                    }
                }
            }
        }
        System.out.println("inValid test");
        for(int scheme=0;scheme<inValidSchemes.length;scheme++){
            for(int auth=0;auth<inValidAuth.length;auth++){
                for(int port=0;port<inValidPort.length;port++){
                    for(int path=0;path<inValidPath.length;path++){
                        String testcase = inValidSchemes[scheme] + inValidAuth[auth] + inValidPort[port] + inValidPath[path];
                        System.out.println(testcase + "      False");
                        assertFalse(urlVal.isValid(testcase));
                    }
                }
            }
        }
    }
}
