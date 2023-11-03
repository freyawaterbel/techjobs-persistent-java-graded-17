--Part 1
id = int
employer = varchar
name = varchar
skills = varchar
SELECT id, employer, name, skills
FROM job
--unclear what this is asking? is there a sql query that gets the data type from a column?

--Part 2
SELECT name
FROM employer
WHERE employer.location = "St. Louis City";

--Part 3
DROP TABLE job;

--Part 4
--SELECT skill.name
--FROM skill
--WHERE skill.id IN (SELECT skills_id FROM job_skills)
--ORDER BY name ASC;

SELECT *
FROM skill
INNER JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC
