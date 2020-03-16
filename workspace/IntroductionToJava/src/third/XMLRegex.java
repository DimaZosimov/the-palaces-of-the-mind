package third;
/**
 * @author Dima Zosimov
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLRegex {

	public static void main(String[] args) {
		String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><notes>" +
		 "<note id = \"1\">" +
		 "<to>Вася</to>" +
		 "<from>Света</from>" +
		 "<heading>Напоминание</heading>" +
		 "<body>Позвони мне завтра!</body>" +
		 "</note>" +
		 "<note id = \"2\">" +
		 "<to>Петя</to>" +
		 "<from>Маша</from>" +
		 "<heading>Важное напоминание</heading>" +
		" </note>" +
		"</notes>";
		
		Pattern patTag = Pattern.compile("<(\\?|\\w)(\\w|\"|\'|=|\\s|\\.|\\-)+(/|\\?)?>");
		Matcher matcherTag = patTag.matcher(s);
		while(matcherTag.find()) {
			String tagOpen = matcherTag.group();
			int startOpenTag = matcherTag.start();
			int endOpenTag = matcherTag.end();
			System.out.println(tagOpen);		//открывающий тег
						
			Pattern patTagName = Pattern.compile("\\w+");
			Matcher matcherTagName = patTagName.matcher(s.substring(startOpenTag, endOpenTag));
			if(matcherTagName.find()) {
				String tagName = matcherTagName.group(0);
				System.out.println(tagName);	//имя тега
				
				Pattern patCloseTag = Pattern.compile("<(\\?|/)?" + tagName + "((\\w|\"|\'|=|\\s|\\.|\\-)+(/|\\?))?>");
				Matcher matcherCloseTag = patCloseTag.matcher(s.substring(endOpenTag));
				if(matcherCloseTag.find()) {
					String tagClose = matcherCloseTag.group(0);
					int startCloseTag = matcherCloseTag.start();
					System.out.println(tagClose);	//закрывающий тег
					System.out.println(s.substring(endOpenTag, endOpenTag+startCloseTag)); //тело тега
					System.out.println(tagOpen + tagClose);
				} else {
					System.out.println(tagOpen);
				}
			}
			
			System.out.println();
		}
	}
					
}
		


