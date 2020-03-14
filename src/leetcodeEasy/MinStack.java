package leetcodeEasy;

import java.util.*;

class MinStack {
        private int minium;
        private int prevMinium;
        private Stack<Integer> stack;

        public MinStack() {
                stack = new Stack<>();
        }

        public void push(int x) {
                if (stack.size() == 0) minium = x;
                if (x <= minium) {
                        prevMinium = minium;
                        minium = x;
                }
                stack.push(x);
        }

        public void pop() {
                int pop = stack.pop();
                if (pop == minium) minium = prevMinium;
        }

        public int top() {
                return stack.peek();
        }

        public int getMin() {
                return stack.stream().mapToInt(s-> s).min().getAsInt();
        }
}
