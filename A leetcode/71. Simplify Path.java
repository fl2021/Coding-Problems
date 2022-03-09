class Solution {
    public String simplifyPath(String path) {
        //把path按照分隔符'/'进行拆解
        //“/+”是正则表达式，代表一个或多个’/‘
        String[] arr = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String s: arr) {
            // 如果栈不为空，返回上级目录
            // 如果栈为空，什么也不做
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            //如果是空字符（比如，“//”之间，或者“.“
            //什么也不做
            else if("".equals(s) || ".".equals(s)) {
                continue;
            } else {
                stack.push(s);
            }
        }
        //如果栈为空，返回“/”
        if (stack.isEmpty()) {
            return "/";
        }
        String str = "";
        //如果栈不为空，构造返回结果
        //结果以“/”开始，不以“/”结束
        while (!stack.isEmpty()) {
            str = "/" + stack.pop() +str;
        }
        return str;
    }
}