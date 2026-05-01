# Q1: AI Resume Screening System

## Scenario

A startup is building an **AI-based recruitment platform** for:
- Resume screening
- Ranking
- Interview scheduling

The system has:
- High daily volume
- Heavy computation (AI models)
- Sensitive data (privacy)
- Limited budget
- Need for scalability

Tasks

- Choose cloud deployment & service model  
- Design AI processing approach  
- Define storage & processing pipeline  

Focus Areas

- Serverless vs Containers  
- Batch vs Real-time processing  
- Compute/CPU optimization  
- Data security  

---

# Solution

### Cloud Deployment & AI Processing System

A hybrid cloud approach is used due to:
- Cost constraints  
- Need to protect sensitive data  
- Requirement for scalability  

```

PRIVATE CLOUD: For sensitive data (resumes, personal info) + PUBLIC CLOUD: For scalable AI processing (ranking, scheduling)

```

#### Private Cloud (Sensitive Data)
- IaaS  
- Firewalls  
- Encryption  

#### Public Cloud (Scalability)
- PaaS → Databases  
- SaaS → Interview scheduling & personalization for companies  

---

### AI Processing Approach

1. NLP Model  
   - Extracts text from resumes  

2. Keyword Matching  
   - Matches job description with resume  
   - Focus on skills & experience  

3. Ranking  
   - Based on ATS friendliness  

4. Interview Scheduling  
   - Top 50 selected from 100  
   - Based on requirements  

---

### Storage & Processing Pipeline

- Object/File storage (PDF/doc)  
- Caching  
- Load balancing (due to high compute)  

---

### Focus

- Serverless (for parsing & uploading)  
- Containers (AI models & computation)  
- Server runs only when needed  

---

### Processing Types

#### Batch Processing
- Resume processing  
- Model training  
- Similar tasks  

#### Real-Time Processing
- Live scrolling  
- Leaderboard  

---

### Data Security

- HTTP + Encryption  
- Private cloud for sensitive data  

---

```

Resume Upload
    ↓
Extraction
    ↓
Model → Keyword Matching
    ↓
DB Storage
    ↓
Sorting & Ranking
    ↓
Leaderboard & 
Interview Scheduling

```


# Q2: OTT Streaming Platform

## Scenario

Design a **video streaming platform** with:

* HD/4K streaming
* Recommendation system
* Multi-device access
* Subscription model

### Constraints:

* High bandwidth
* Global scalability
* Zero buffering experience
* Large storage

### Tasks:

* Design video delivery system
* Select cloud model
* Plan global scaling

### Focus Areas:

* Distributed storage
* Auto-scaling
* Recommendation system
* CDN & edge delivery

---

# Solution

### Storage & Delivery

* Cloud S3 (object storage)
* CDN for global delivery

---

### Streaming

* **HLS (HTTP Live Streaming)**

  + Video divided into small chunks
  + Sent progressively instead of full video
  + Reduces bandwidth overhead

---

### Auto Scaling

* Kubernetes
* Elastic scaling

---

### Recommendation System

* Based on:

  + User watched videos
  + Trending content
  + “Might like” suggestions

---

### Distributed System

* Content cached on nearby servers
* Accessed by users globally

---

### Edge / Fog Computing

* Stores user clicks
* Syncs to cloud
* Tracks:

  + Trends
  + Most watched videos

---

### Cost Model

* Pay-as-you-go

---

### Video Flow

```
Video Upload → Data Save → HLS → User
```
