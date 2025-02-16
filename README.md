# Quiz-Application
# 🎯 Quiz Application – Online Examination Portal  

Welcome to the **Quiz Application** 🎓, a **full-stack** online examination system built with **Spring Boot, Angular, and MySQL**. This project provides a seamless experience for both **users** (students) and **admins** (test creators) with real-time monitoring, automatic submission, and performance tracking.  

## 🚀 Tech Stack  
- **Backend**: Java Spring Boot  
- **Frontend**: Angular  
- **Database**: MySQL  
- **Additional**: REST APIs, JSON  

## 📌 Project Overview  
This **Quiz Application** allows **users** to take online quizzes while enabling **admins** to create and manage tests. Users can sign up, log in, take tests, and view their results. The platform supports **real-time test monitoring**, **automatic submission when time runs out**, and an **admin dashboard** to track test performances.  

---

## 🔥 Features  

### 🛠 Admin Features  
✅ **Automatic Admin Creation** – A default admin account (`admin@gmail.com / admin`) is created automatically upon startup.  
✅ **Test & Question Management** – Admins can create **tests** with **questions** having **four options** and **one correct answer**.  
✅ **View Test Results** – Admins can view **user performance**, correct answers, and overall test scores.  

### 👩‍🎓 User Features  
✅ **User Signup & Login** – Users can register and log in to access quizzes.  
✅ **Taking Tests** – Users can attempt available quizzes with **multiple-choice questions**.  
✅ **⏳ Real-Time Monitoring** – A timer ensures users stay within the allocated time.  
✅ **⚡ Automatic Submission** – If time runs out, answers are auto-submitted.  
✅ **📊 View Results** – After completing a test, users can see their **scores and performance analytics**.  

---

## 📷 Screenshots  
🖥️ **Admin Dashboard** – Manage quizzes, questions, and view results.  
📱 **User Dashboard** – Select tests, take quizzes, and track scores.  
⏳ **Timer-Based Testing** – Prevents users from exceeding the time limit.  

---

## 🔗 API Endpoints  

### 📝 User APIs  
#### Signup  
```http
POST /sign-up
