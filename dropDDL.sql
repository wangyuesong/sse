ALTER TABLE document DROP FOREIGN KEY FK_document_USER_ID
ALTER TABLE document DROP FOREIGN KEY FK_document_DOCUMENTTYPE_ID
ALTER TABLE topic DROP FOREIGN KEY FK_topic_TOPICTYPE_ID
ALTER TABLE user DROP FOREIGN KEY FK_user_MENTOR_ID
DROP TABLE document
DROP TABLE documenttype
DROP TABLE topic
DROP TABLE topictype
DROP TABLE user
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
