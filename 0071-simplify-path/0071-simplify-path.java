class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        return ans.toString();
    }
}