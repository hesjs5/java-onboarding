package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> getAlreadyFriendWithUserListFromFriends(String user, List<List<String>> friends) {

        List<String> alreadyFriendList = new ArrayList<>();

        for (List<String> friend : friends) {

            if (friend.contains(user)) {
                List<String> temp = friend.stream()
                        .filter((name) -> !name.equals(user))
                        .collect(Collectors.toList());

                alreadyFriendList.addAll(temp);
            }
        }

        return alreadyFriendList;
    }

    static List<String> getPotentialFriendWithUserListFromFriendsAndVisitors(String user, List<List<String>> friends, List<String> visitors) {

        Set<String> set = friends.stream()
                .flatMap(Collection::stream)
                .filter(name -> !name.equals(user))
                .collect(Collectors.toSet());

        Set<String> temp = new HashSet<>(visitors);

        set.addAll(temp);

        List<String> potentialFriendList = new ArrayList<>(set);
        List<String> alreadyFriendWithUserListFromFriends = getAlreadyFriendWithUserListFromFriends(user, friends);

        potentialFriendList.removeAll(alreadyFriendWithUserListFromFriends);

//        System.out.println("potentialFriendList = " + potentialFriendList);

        return potentialFriendList;
    }
}
