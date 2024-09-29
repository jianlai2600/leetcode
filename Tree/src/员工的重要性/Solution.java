package 员工的重要性;

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
class Solution {
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        Queue<Employee>queue = new LinkedList<>();
        int ret = 0;
        queue.add(map.get(id));

        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            ret += e.importance;
            List<Integer>list = e.subordinates;

            if (list == null) {
                continue;
            }
            for (Integer num : list) {
                queue.add(map.get(num));
            }
        }

        return ret;
    }

    public static void main(String[] args){

        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;

        e1.subordinates = new ArrayList<>();
        e1.subordinates.add(2);
        e1.subordinates.add(3);

        List<Employee>employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        Solution sol = new Solution();
        int ret = sol.getImportance(employees, 1);

        System.out.println(ret);
    }
}


