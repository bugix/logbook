INSERT INTO administrator (email, name, pre_name, version) VALUES ('m.imobersteg@unibas.ch', 'Imobersteg', 'Martin', 1);

INSERT INTO student (email, gender, name, pre_name, shib_id, student_id, student_status, study_year, version) VALUES ('susi.sorglos@no.way', 2, 'Sorglos', 'Susi', '1', '1', 1, 1, 1);

INSERT INTO keyword (name, version) VALUES ('Keyword_1', '1');
INSERT INTO keyword (name, version) VALUES ('Keyword_2', '1');
INSERT INTO keyword (name, version) VALUES ('Keyword_3', '1');
INSERT INTO keyword (name, version) VALUES ('Keyword_4', '1');
INSERT INTO keyword (name, version) VALUES ('Keyword_5', '1');

INSERT INTO main_classification (description, shortcut, version) VALUES ('Main Classification 1', 'SC', 1);

INSERT INTO classification_topic (description, shortcut, version, main_classification) VALUES ('Classification Topic 1', 'SC', 1, 1);

INSERT INTO topic (topic_description, version, classification_topic) VALUES ('Topic 1', 1, 1);
INSERT INTO topic (topic_description, version, classification_topic) VALUES ('Topic 2', 1, 1);

INSERT INTO skill_level (level_number, version) VALUES (1, 1);
INSERT INTO skill_level (level_number, version) VALUES (2, 1);

INSERT INTO skill (description, german_text, shortcut, version, skill_level, topic) VALUES ('Skill 1', 'Fähigkeit 1', 1, 1, 1, 1);
INSERT INTO skill (description, german_text, shortcut, version, skill_level, topic) VALUES ('Skill 2', 'Fähigkeit 2', 2, 1, 2, 1);

INSERT INTO skill (description, german_text, shortcut, version, skill_level, topic) VALUES ('Skill 3', 'Fähigkeit 3', 3, 1, 1, 2);
INSERT INTO skill (description, german_text, shortcut, version, skill_level, topic) VALUES ('Skill 4', 'Fähigkeit 4', 4, 1, 2, 2);

INSERT INTO keyword_skill (keywords, skill) VALUES (1, 1);
INSERT INTO keyword_skill (keywords, skill) VALUES (3, 1);
INSERT INTO keyword_skill (keywords, skill) VALUES (5, 1);

INSERT INTO keyword_skill (keywords, skill) VALUES (2, 2);

INSERT INTO keyword_skill (keywords, skill) VALUES (4, 3);
INSERT INTO keyword_skill (keywords, skill) VALUES (5, 3);

INSERT INTO keyword_skill (keywords, skill) VALUES (1, 4);
INSERT INTO keyword_skill (keywords, skill) VALUES (3, 4);
INSERT INTO keyword_skill (keywords, skill) VALUES (5, 4);