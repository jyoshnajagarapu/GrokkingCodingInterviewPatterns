package Graph;
import java.util.*;
//When a router receives this message, it broadcasts the same message to all other routers within its wireless range.
//Then, that router shuts down, and can no longer send or receive messages.
//
//
//For example, Router A is at (0, 0); Router B is at (0, 8); Router C is at (0, 17); Router D is at (11, 0).
//
//If the wireless range is 10, when Router A sends a message, it could first reach B; the message from Router B would further reach Router C but Router D would never receive this message.
//
//Given a list of routers' locations (their names and the corresponding 2D coordinates), tell me whether a message from Router A can reach Router
public class RouterBroadcast {
    static class Router {
        String name;
        int x, y;

        Router(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }

    public static boolean canMessageReach(List<Router> routers, String fromName, String toName, double range) {
        Map<String, Router> routerMap = new HashMap<>();
        for (Router router : routers) {
            routerMap.put(router.name, router);
        }

        if (!routerMap.containsKey(fromName) || !routerMap.containsKey(toName)) {
            return false;
        }

        Router startRouter = routerMap.get(fromName);
        Router endRouter = routerMap.get(toName);

        Set<String> visited = new HashSet<>();
        Queue<Router> queue = new LinkedList<>();
        queue.add(startRouter);
        visited.add(startRouter.name);

        while (!queue.isEmpty()) {
            Router current = queue.poll();
            if (current.name.equals(endRouter.name)) {
                return true;
            }

            for (Router neighbor : routers) {
                if (!visited.contains(neighbor.name) && isWithinRange(current, neighbor, range)) {
                    queue.add(neighbor);
                    visited.add(neighbor.name);
                }
            }
        }
        return false;
    }

    private static boolean isWithinRange(Router a, Router b, double range) {
        double distance = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        return distance <= range;
    }

    // Test cases
    public static void main(String[] args) {
        List<Router> routers = Arrays.asList(
                new Router("A", 0, 0),
                new Router("B", 0, 8),
                new Router("C", 0, 17),
                new Router("D", 11, 0)
        );

        System.out.println(canMessageReach(routers, "A", "B", 10)); // Output: true
        System.out.println(canMessageReach(routers, "A", "C", 10)); // Output: true
        System.out.println(canMessageReach(routers, "A", "D", 10)); // Output: false
        System.out.println(canMessageReach(routers, "B", "D", 10)); // Output: false
        System.out.println(canMessageReach(routers, "C", "D", 10)); // Output: false
    }
}