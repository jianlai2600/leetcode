package BrowserHistory;

import java.util.LinkedList;

class BrowserHistory {
    LinkedList<String>list;
    int idx;
    public BrowserHistory(String homepage) {
        list = new LinkedList<>();
        list.add(homepage);
        idx = 0;
    }

    public void visit(String url) {

        while (list.size() > idx + 1) {
            list.removeLast();
        }
        list.add(url);
        idx++;
    }

    public String back(int steps) {
        if (steps > idx) {
            idx = 0;
            return list.get(idx);
        } else {

            idx -= steps;
            return list.get(idx);
        }
    }

    public String forward(int steps) {

        int dis = list.size() - idx - 1;
        if (steps > dis) {
            idx += dis;
            return list.get(idx);
        }
        idx += steps;
        return list.get(idx);
    }
}
