# 06_Adv_Java

Advanced Java practice projects and mini web applications using Java Servlets, JSP, JDBC, MySQL, and Apache Tomcat.

## Folder Contents

| Folder | Description |
| --- | --- |
| `HospitalManagmentSystem` | Hospital login/dashboard practice project. |
| `LibraryManagementSystem` | Library book CRUD and login project. |
| `LoginPractice` | Basic servlet login/session practice. |
| `OnlineFoodOrderingManagementSystem` | Food ordering servlet/JSP project with menu, cart, and orders. |
| `OnlineFoodOrderingSystem` | Eclipse web project shell. |
| `PatientManagement` | Patient management servlet/JSP project. |
| `SERVLET` | Servlet practice folders. |
| `StudentManagement` | Student management servlet/JSP project. |
| `StudentManagment` | Student registration/list servlet/JSP project. |

## Notes Before Running

- These are Eclipse Dynamic Web Projects, not Maven/Gradle projects.
- Use Apache Tomcat 9 and MySQL.
- Add the MySQL Connector/J jar in your server or project build path.
- Eclipse workspace metadata, compiled classes, build output, and local Tomcat server configuration are ignored from git.
- Database passwords are read from environment variables and are not committed.

## Database Environment Variables

Set these only when the default local database/user is not enough:

| Project | Variables |
| --- | --- |
| Hospital | `HOSPITAL_DB_URL`, `HOSPITAL_DB_USERNAME`, `HOSPITAL_DB_PASSWORD` |
| Library | `LIBRARY_DB_URL`, `LIBRARY_DB_USERNAME`, `LIBRARY_DB_PASSWORD` |
| Food Ordering | `FOOD_ORDERING_DB_URL`, `FOOD_ORDERING_DB_USERNAME`, `FOOD_ORDERING_DB_PASSWORD` |
| Patient | `PATIENT_DB_URL`, `PATIENT_DB_USERNAME`, `PATIENT_DB_PASSWORD` |
| Student | `STUDENT_DB_URL`, `STUDENT_DB_USERNAME`, `STUDENT_DB_PASSWORD` |

## Git Commands

From the repository root:

```powershell
git add CDAC_LAB/06_Adv_Java
git status
git commit -m "Add advanced Java projects"
git push
```
