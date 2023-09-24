INSERT INTO role (id, name) VALUES (1, 'admin'), (2, 'enfermeira'), (3, 'recepcionista');
INSERT INTO user_model (id, email, password) VALUES (1, 'admin@gmail.com', '$2a$12$QvpagGftSUAo.J7BAArVQ.6GIHlysYlsE2r9ao.pWcR3/lvsKCnq6'), (2, 'enfermeira@gmail.com', '$2a$12$QvpagGftSUAo.J7BAArVQ.6GIHlysYlsE2r9ao.pWcR3/lvsKCnq6'), (3, 'recepcionista@gmail.com', '$2a$12$QvpagGftSUAo.J7BAArVQ.6GIHlysYlsE2r9ao.pWcR3/lvsKCnq6');
INSERT INTO user_model_roles (users_id, roles_id) VALUES (1, 1), (2, 2), (3, 3);
