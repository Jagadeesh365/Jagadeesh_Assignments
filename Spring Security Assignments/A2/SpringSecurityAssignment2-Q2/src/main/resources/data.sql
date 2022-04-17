INSERT INTO users(username,password,enabled)
values('sam','$2a$10$tTFOxtSWNNS1VoKN1jLW5umr9AVILaEqcfv3qiN4HbaN4K1BGfm6y',true);

INSERT INTO users(username,password,enabled)
values('syed','$2a$10$Amk4RE4ycv3zCZNgJDqLbOp4Xum82eZrmKkafn12dbMN2a1qcAzlm',true);

INSERT INTO authorities(username,authority)
values('sam','ROLE_USER');

INSERT INTO authorities(username,authority)
values('syed','ROLE_ADMIN');