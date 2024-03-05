# 🍂 Spring Boot Scheduled Annotation 🍂

## Configuration 🔩

To enable the Scheduled Annotation we can use the Java enable-style annotation:

```
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ScheduleApplication {
    ...
}
```
- **@EnableScheduling:** enable java scheduling.
- **@EnableAsync:** enable support parallel behavior in scheduled tasks.

## FixedRate ⌚

The fixedRate property runs the scheduled task at every n millisecond. It doesn’t check for any previous executions of the task.
This is useful when all executions of the task are independent.

### Example 📋

```
// Schedule a job to run every 10 seconds using fixedRate
@Scheduled(fixedRate = 10000)
public void scheduleFixedRateTask() {
	logger.info("Job Current Time (FixedRate): " + new Date());
}
```

## FixedDelay ⏳

The fixedDelay property makes sure that there is a delay of n millisecond between the finish time of an execution of a task and the start time of the next execution of the task.
This property is specifically useful when we need to make sure that only one instance of the task runs all the time.

### Example 📋

```
// Schedule a job to run every 5 seconds using fixedDelay
@Scheduled(fixedDelay = 5000)
public void scheduleFixedDelayTask() {
	logger.info("Job Current Time (FixedDelay): " + new Date());
}
```

## Cron 📅

It is a resource that allows you to configure more specific dates and times for tasks, specifying the minutes, hours or even the day on which the given program will be executed.

### Format 👾

@Scheduled(cron = "A B C D E F")

| Field | Meaning | Possible Values | Description |
|--------------|--------------|--------------|--------------|
| A    | Seconds | 0 - 59  | The seconds at which the task will run   |
| B    | Minutes | 0 - 59  | The minutes at which the task will run    |
| C    | Hours   | 0 - 23  | The hours at which the task will run    |
| D    | Day of the month | 1 - 31  | The day of the month on which the task will run   |
| E    | Month | 1 - 12  | The month in which the task will run    |
| F    | Day of the week   | 0 - 6  | The day of the week on which the task will run  |


### Adittional Values ➕

| Value | Description |
|--------------|--------------|
| *    | Represents all possible values ​​for the field in which it is located. For example, if you place an asterisk in the minutes field, it indicates that the task will run every minute  |
| /    | Is used to define regular intervals. For example, if you use */15 in the minutes field, it indicates that the task will run every 15 minutes  |
| -    | Is used to define ranges of values. For example, if you specify 1-5 in the days of the week field, it indicates that the task will run from Monday (1) to Friday (5)  |
| ,    | Is used to specify a list of values. For example, if you put 1,3,5 in the days of the week field, it indicates that the task will run on Monday, Wednesday, and Friday  |
| ?    | Is used in the day of the week or day of the month field to indicate "not specified". It is useful when you want to leave a field undefined  |

### Example 📋

Every day at 19:30:00

```
@Scheduled(cron = "0 30 19 * * ?")
public void scheduleTaskUsingCronExpression() {
	logger.info("Job Current Time (CronExpression): " + new Date());
}
```

## References 📚
- https://www.baeldung.com/spring-scheduled-tasks
- https://www.aluracursos.com/blog/programando-tareas-con-scheduled-de-spring
