package Interviews;


import java.util.Stack;

/**
 * Given html string, and length return the printable html of length
 * ex: input: <p>the <b>quick</b> fox can jump</p>, 10
 * output: <p>the <b>quick</b> </p> (total 10 chars not including html tags)
 */
public class UBER_BlogPostShortner {
    public static void main(String[] args) {
        String result = blogPostShortner("<p>the <div>quick</div> fox can jump</p>", 10);
        System.out.println(result);
    }

    public static String blogPostShortner(String html, int length) {
        StringBuilder result = new StringBuilder();
        int resultLength = 0;
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < html.length(); i ++) {
            if(html.charAt(i) == '<') {
                int closeIndex = html.indexOf('>', i);
                String htmlTag = html.substring(i, closeIndex + 1);
                if(!htmlTag.startsWith("</")) {
                    stack.push(htmlTag.substring(1, htmlTag.length() - 1));
                } else {
                    stack.pop();
                }
                result.append(htmlTag);
                i = closeIndex;
                continue;
            }

            result.append(html.charAt(i));
            resultLength ++;

            if(resultLength == length) {
                while (!stack.isEmpty()) {
                    result.append("</" + stack.pop() + ">");
                }
                return result.toString();
            }
        }

        return result.toString();
    }
}
