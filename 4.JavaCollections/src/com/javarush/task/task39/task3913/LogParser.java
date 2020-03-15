package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path pathLogs; //log dir
    File[] files;


    public LogParser(Path logDir) {
        this.pathLogs = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ips = getUniqueIPs(after, before);
        return ips.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = getLogs().stream().filter(log -> isDateCorrect(log.getDate(), after, before))
                .map(LogItem::getIp).collect(Collectors.toSet());
        return ips;
    }

    private Date getDate(String[] parsedLine) {
        String date = parsedLine[parsedLine.length - 3];
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date value = null;
        try {
            value = formatter.parse(date);
        } catch (ParseException e) {
        }
        return value;
    }

    private Date getDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date value = null;
        try {
            value = formatter.parse(date);
        } catch (ParseException e) {
        }
        return value;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips_event = getLogs().stream().filter(log -> isDateCorrect(log.getDate(), after, before)
                && log.getUser().equals(user)).map(LogItem::getIp).collect(Collectors.toSet());
        return ips_event;
    }


    public Set<String> getIPsForDate(Date date,Date after, Date before) {
        Set<String> ips_event = getLogs().stream().filter(log -> isDateCorrect(log.getDate(), after, before)
                &&log.getDate().equals(date))
                .map(LogItem::getIp).collect(Collectors.toSet());
        return ips_event;
    }

    private List<LogItem> getLogs() {
        files = pathLogs.toFile().listFiles();
        List<LogItem> logs = new ArrayList<>();
        for (File file : files) {
            if (!file.getName().endsWith(".log")) continue;
            try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
                while (fr.ready()) {
                    String[] parsedLine = fr.readLine().split("\\t");
                    Date date = getDate(parsedLine);
                    logs.add(new LogItem(parsedLine[0], parsedLine[1], date, parsedLine[3], parsedLine[4]));
                }
            } catch (IOException e) {

            }
        }
        return logs;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips_event = new HashSet<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && String.valueOf(event).equals(actEvent)) {
                ips_event.add(log.getIp());
            }
        }
        return ips_event;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips_event = getLogs().stream().filter(log -> isDateCorrect(log.getDate(), after, before)
                && String.valueOf(status).equals(log.getStatus())).map(LogItem::getIp).collect(Collectors.toSet());
        return ips_event;
    }

    public boolean isDateCorrect(Date inputDate, Date after, Date before) {
        if (after == null && before == null) {
            return true;
        }
        if (after == null && (inputDate.before(before))) {
            return true;
        }
        if (before == null && (inputDate.after(after))) {
            return true;
        }
        return (before != null && after != null) && (inputDate.after(after))
                && (inputDate.before(before));
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = getLogs().stream().map(LogItem::getUser).collect(Collectors.toSet());
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = getLogs().stream().filter(log -> isDateCorrect(log.getDate(), after, before))
                .map(LogItem::getIp).collect(Collectors.toSet());
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<String> events = getLogs().stream().filter(log -> isDateCorrect(log.getDate(), after, before) &&
                log.getUser().equals(user))
                .map(LogItem::getEvent).collect(Collectors.toSet());
        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        getLogs().forEach(log -> {
            String ipActual = log.getIp();
            if (isDateCorrect(log.getDate(), after, before) && ip.equals(ipActual)) {
                users.add(log.getUser());
            }
        });
        return users;
    }

    public Set<String> getUsersForDate(Date date, Date after, Date before) {
        Set<String> users = new HashSet<>();
        getLogs().forEach(log -> {
            if (isDateCorrect(log.getDate(), after, before) && log.getDate().equals(date)) {
                users.add(log.getUser());
            }
        });
        return users;
    }

    public Set<String> getUsersForEvent(String event, Date after, Date before) {
        Set<String> users = new HashSet<>();
        getLogs().forEach(log -> {
            String[] fullevent = log.getEvent().split(" ");
            if (isDateCorrect(log.getDate(), after, before) && fullevent[0].equals(event)) {
                users.add(log.getUser());
            }
        });
        return users;
    }

    public Set<String> getUsersForStatus(String status, Date after, Date before) {
        Set<String> users = new HashSet<>();
        getLogs().forEach(log -> {
            if (isDateCorrect(log.getDate(), after, before) && log.getStatus().equals(status)) {
                users.add(log.getUser());
            }
        });
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogItem log : getLogs()) {
            String actEvent = log.getEvent();
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.LOGIN))) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogItem log : getLogs()) {
            String actEvent = log.getEvent();
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.DOWNLOAD_PLUGIN))) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogItem log : getLogs()) {
            String actEvent = log.getEvent();
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.WRITE_MESSAGE))) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.SOLVE_TASK))) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.SOLVE_TASK))) {
                int actTask = Integer.parseInt(actEvents[1]);
                if (actTask == task) {
                    users.add(log.getUser());
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        getLogs().forEach(log -> {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.DONE_TASK))) {
                users.add(log.getUser());
            }
        });
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.DONE_TASK))) {
                int actTask = Integer.parseInt(actEvents[1]);
                if (actTask == task) {
                    users.add(log.getUser());
                }
            }
        }
        return users;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && log.getUser().equals(user)
                    && actEvent.equals(String.valueOf(event))) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getStatus().equals(String.valueOf(Status.FAILED))) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getStatus().equals(String.valueOf(Status.ERROR))) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date firstLogin = null;
        List<Date> dates = new ArrayList<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getUser().equals(user)
                    && log.getEvent().equals(String.valueOf(Event.LOGIN))) {
                Date userLoginDate = log.getDate();
                dates.add(userLoginDate);
            }
        }
        if (!dates.isEmpty()) {
            Collections.sort(dates);
            return dates.get(0);
        }

        return firstLogin;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date date = null;
        List<Date> dates = new ArrayList<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.SOLVE_TASK))
                    && log.getUser().equals(user)) {
                int actTask = Integer.parseInt(actEvents[1]);
                if (actTask == task) {
                    date = log.getDate();
                    dates.add(date);
                }
            }
        }
        if (!dates.isEmpty()) {
            Collections.sort(dates);
            return dates.get(0);
        }
        return date;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date date = null;
        List<Date> dates = new ArrayList<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.DONE_TASK))
                    && log.getUser().equals(user)) {
                int actTask = Integer.parseInt(actEvents[1]);
                if (actTask == task) {
                    date = log.getDate();
                    dates.add(date);
                }
            }
        }
        if (!dates.isEmpty()) {
            Collections.sort(dates);
            return dates.get(0);
        }
        return date;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getUser().equals(user)
                    && log.getEvent().equals(String.valueOf(Event.WRITE_MESSAGE))) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getUser().equals(user)
                    && log.getEvent().equals(String.valueOf(Event.DOWNLOAD_PLUGIN))) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    public Set<Date> getDatesForUser(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getUser().equals(user)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    public Set<Date> getDatesForIP(String ip, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getIp().equals(ip)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    public Set<Date> getDatesForEvent(String event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            String[] fullEvent=log.getEvent().split(" ");
            if (isDateCorrect(log.getDate(), after, before) && fullEvent[0].equals(event)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    public Set<Date> getDatesForStatus(String status, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getStatus().equals(status)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> events = getAllEvents(after, before);
        return events.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before)) {
                String[] fullEvent = log.getEvent().split(" ");
                events.add(createEvent(fullEvent[0]));
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && ip.equals(log.getIp())) {
                String[] fullEvent = log.getEvent().split(" ");
                events.add(createEvent(fullEvent[0]));
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && user.equals(log.getUser())) {
                String[] fullEvent = log.getEvent().split(" ");
                events.add(createEvent(fullEvent[0]));
            }
        }
        return events;
    }

    public Set<Event> getEventsForDate(Date date, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && date.equals(log.getDate())) {
                String[] fullEvent = log.getEvent().split(" ");
                events.add(createEvent(fullEvent[0]));
            }
        }
        return events;
    }

    public Set<Event> getEventsForStatus(String status, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && status.equals(log.getStatus())) {
                String[] fullEvent = log.getEvent().split(" ");
                events.add(createEvent(fullEvent[0]));
            }
        }
        return events;
    }

    public Set<Status> getStatusForIp(String ip, Date after, Date before) {
        Set<Status> statuses = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && ip.equals(log.getIp())) {
                String[] fullStatus = log.getStatus().split(" ");
                statuses.add(createStatus(fullStatus[0]));
            }
        }
        return statuses;
    }

    public Set<Status> getStatusForUser(String user, Date after, Date before) {
        Set<Status> statuses = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && user.equals(log.getUser())) {
                String[] fullStatus = log.getStatus().split(" ");
                statuses.add(createStatus(fullStatus[0]));
            }
        }
        return statuses;
    }

    public Set<Status> getStatusForDate(Date date, Date after, Date before) {
        Set<Status> statuses = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && date.equals(log.getDate())) {
                String[] fullStatus = log.getStatus().split(" ");
                statuses.add(createStatus(fullStatus[0]));
            }
        }
        return statuses;
    }

    public Set<Status> getStatusForEvent(String event, Date after, Date before) {
        Set<Status> statuses = new HashSet<>();
        for (LogItem log : getLogs()) {
            String[]fullEvent = log.getEvent().split(" ");
            if (isDateCorrect(log.getDate(), after, before) && event.equals(fullEvent[0])) {
                String[] fullStatus = log.getStatus().split(" ");
                statuses.add(createStatus(fullStatus[0]));
            }
        }
        return statuses;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getStatus().equals((Status.FAILED).toString())) {
                String[] fullEvent = log.getEvent().split(" ");
                events.add(createEvent(fullEvent[0]));
            }
        }
        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogItem log : getLogs()) {
            if (isDateCorrect(log.getDate(), after, before) && log.getStatus().equals((Status.ERROR).toString())) {
                String[] fullEvent = log.getEvent().split(" ");
                events.add(createEvent(fullEvent[0]));
            }
        }
        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int attempts = 0;
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.SOLVE_TASK))) {
                int actTask = Integer.parseInt(actEvents[1]);
                if (actTask == task) {
                    attempts++;
                }
            }
        }
        return attempts;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int attempts = 0;
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.DONE_TASK))) {
                int actTask = Integer.parseInt(actEvents[1]);
                if (actTask == task) {
                    attempts++;
                }
            }
        }
        return attempts;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> attempts = new HashMap<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.SOLVE_TASK))) {
                int actTask = Integer.parseInt(actEvents[1]);
                attempts.merge(actTask, 1, Integer::sum);
            }
        }
        return attempts;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> attempts = new HashMap<>();
        for (LogItem log : getLogs()) {
            String[] actEvents = log.getEvent().split(" ");
            String actEvent = actEvents[0];
            if (isDateCorrect(log.getDate(), after, before) && actEvent.equals(String.valueOf(Event.DONE_TASK))) {
                int actTask = Integer.parseInt(actEvents[1]);
                attempts.merge(actTask, 1, Integer::sum);
            }
        }
        return attempts;
    }

    public Set<Date> getAllDates() {
        Set<Date> dates = new HashSet<>();
        for (LogItem log : getLogs()) {
            dates.add(log.getDate());
        }
        return dates;
    }

    public Set<Status> getAllStatuses() {
        Set<Status> sts = new HashSet<>();
        for (LogItem log : getLogs()) {
            Status st = Status.valueOf(log.getStatus());
            sts.add(st);
        }
        return sts;
    }


    private Event createEvent(String event) {
        return Event.valueOf(event);
    }

    private Status createStatus(String status) {
        return Status.valueOf(status);
    }

    @Override
    public Set<Object> execute(String query) {
        String param1 = "";
        String param2 = "";
        String after = "";
        String before = "";
        String value = "";
        Set<Object> set = new HashSet<>();
        if (query.contains("between")) {
            String regex = "get (?<field1>\\w+) for (?<field2>\\w+) = \"(?<value1>.*?)\" and date between \"(?<after>.*?)\" and \"(?<before>.*?)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) {
                param1 = matcher.group("field1");
                param2 = matcher.group("field2");
                value = matcher.group("value1");
                after = matcher.group("after");
                before = matcher.group("before");
            }
            return getSetByParams(param1, param2, value, after, before);
        }
        if (query.contains("=")) {
            String regex = "get (?<field1>\\w+) for (?<field2>\\w+) = \"(?<value1>.*?)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) {
                param1 = matcher.group("field1");
                param2 = matcher.group("field2");
                value = matcher.group("value1");
            }
            return getSetByParams(param1, param2, value);
        } else {
                switch (query) {
                    case "get ip":
                        return new HashSet<>(getUniqueIPs(null, null));
                    case "get user":
                        return new HashSet<>(getAllUsers());
                    case "get date":
                        return new HashSet<>(getAllDates());
                    case "get event":
                        return new HashSet<>(getAllEvents(null, null));
                    case "get status":
                        return new HashSet<>(getAllStatuses());
                }
        }
        return set;
    }

    private Set<Object> getSetByParams(String field1, String field2, String value1, String after, String before) {
        Set<Object> results = new HashSet<>();
        if (field1.equals("ip")) {
            Set<String> res1 = new HashSet<>();
            if (field2.equals("user")) {
                res1 = getIPsForUser(value1, getDate(after), getDate(before));
            } else if (field2.equals("date")) {
                res1 = getIPsForDate(getDate(value1),getDate(after), getDate(before));
            } else if (field2.equals("event")) {
                res1 = getIPsForEvent(Event.valueOf(value1), getDate(after), getDate(before));
            } else if (field2.equals("status")) {
                res1 = getIPsForStatus(Status.valueOf(value1),getDate(after), getDate(before));
            }
            results.addAll(res1);
        }
        if (field1.equals("user")) {
            Set<String> res1 = new HashSet<>();
            if (field2.equals("ip")) {
                res1 = getUsersForIP(value1, getDate(after), getDate(before));
            } else if (field2.equals("date")) {
                res1 = getUsersForDate(getDate(value1), getDate(after), getDate(before));
            } else if (field2.equals("event")) {
                res1 = getUsersForEvent(value1, getDate(after), getDate(before));
            } else if (field2.equals("status")) {
                res1 = getUsersForStatus(value1, getDate(after), getDate(before));
            }
            results.addAll(res1);
        }
        if (field1.equals("date")) {
            Set<Date> res1 = new HashSet<>();
            if (field2.equals("ip")) {
                res1 = getDatesForIP(value1, getDate(after), getDate(before));
            } else if (field2.equals("user")) {
                res1 = getDatesForUser(value1, getDate(after), getDate(before));
            } else if (field2.equals("event")) {
                res1 = getDatesForEvent(value1, getDate(after), getDate(before));
            } else if (field2.equals("status")) {
                res1 = getDatesForStatus(value1, getDate(after), getDate(before));
            }
            results.addAll(res1);
        }
        if (field1.equals("event")) {
            Set<Event> res1 = new HashSet<>();
            if (field2.equals("user")) {
                res1 = getEventsForUser(value1, getDate(after), getDate(before));
            } else if (field2.equals("ip")) {
                res1 = getEventsForIP(value1, getDate(after), getDate(before));
            } else if (field2.equals("date")) {
                res1 = getEventsForDate(getDate(value1),getDate(after), getDate(before));
            } else if (field2.equals("status")) {
                res1 = getEventsForStatus(value1, getDate(after), getDate(before));
            }
            results.addAll(res1);
        }

        if (field1.equals("status")) {
            Set<Status> res1 = new HashSet<>();
            if (field2.equals("user")) {
                res1 = getStatusForUser(value1, getDate(after), getDate(before));
            } else if (field2.equals("ip")) {
                res1 = getStatusForIp(value1, getDate(after), getDate(before));
            } else if (field2.equals("date")) {
                res1 = getStatusForDate(getDate(value1), getDate(after), getDate(before));
            } else if (field2.equals("event")) {
                res1 = getStatusForEvent(value1, getDate(after), getDate(before));
            }
            results.addAll(res1);
        }

        return results;
    }

    private Set<Object> getSetByParams(String field1, String field2, String value1) {
        Set<Object> results = new HashSet<>();
        if (field1.equals("ip")) {
            Set<String> res1 = new HashSet<>();
            if (field2.equals("user")) {
                res1 = getIPsForUser(value1, null, null);
            } else if (field2.equals("date")) {
                res1 = getIPsForDate(getDate(value1), null, null);
            } else if (field2.equals("event")) {
                res1 = getIPsForEvent(Event.valueOf(value1), null, null);
            } else if (field2.equals("status")) {
                res1 = getIPsForStatus(Status.valueOf(value1), null, null);
            }
            results.addAll(res1);
        }
        if (field1.equals("user")) {
            Set<String> res1 = new HashSet<>();
            if (field2.equals("ip")) {
                res1 = getUsersForIP(value1, null, null);
            } else if (field2.equals("date")) {
                res1 = getUsersForDate(getDate(value1), null, null);
            } else if (field2.equals("event")) {
                res1 = getUsersForEvent(value1, null, null);
            } else if (field2.equals("status")) {
                res1 = getUsersForStatus(value1, null, null);
            }
            results.addAll(res1);
        }
        if (field1.equals("date")) {
            Set<Date> res1 = new HashSet<>();
            if (field2.equals("ip")) {
                res1 = getDatesForIP(value1, null, null);
            } else if (field2.equals("user")) {
                res1 = getDatesForUser(value1, null, null);
            } else if (field2.equals("event")) {
                res1 = getDatesForEvent(value1, null, null);
            } else if (field2.equals("status")) {
                res1 = getDatesForStatus(value1, null, null);
            }
            results.addAll(res1);
        }
        if (field1.equals("event")) {
            Set<Event> res1 = new HashSet<>();
            if (field2.equals("user")) {
                res1 = getEventsForUser(value1, null, null);
            } else if (field2.equals("ip")) {
                res1 = getEventsForIP(value1, null, null);
            } else if (field2.equals("date")) {
                res1 = getEventsForDate(getDate(value1), null, null);
            } else if (field2.equals("status")) {
                res1 = getEventsForStatus(value1, null, null);
            }
            results.addAll(res1);
        }

        if (field1.equals("status")) {
            Set<Status> res1 = new HashSet<>();
            if (field2.equals("user")) {
                res1 = getStatusForUser(value1, null, null);
            } else if (field2.equals("ip")) {
                res1 = getStatusForIp(value1, null, null);
            } else if (field2.equals("date")) {
                res1 = getStatusForDate(getDate(value1), null, null);
            } else if (field2.equals("event")) {
                res1 = getStatusForEvent(value1, null, null);
            }
            results.addAll(res1);
        }

        return results;
    }
}