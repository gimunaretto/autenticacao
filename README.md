### TURMA: 1SCJR
### WEBSERVICES & RESTFUL TECHNOLOGIES

- 347328 - THIAGO RODRIGUES DIAS
- 347114 - DANIEL DA CUNHA NOBREGA
- 346982 - GIULIANA FERNANDES MUNARETTO
- 346669 - JORGE ROSIVAN RODRIGUES BATISTA
- 347374 - PEDRO SANTANA
- 346541 - ROBERTO GUEDES GARRONES  
--------

#### Github do Front: (usar a branch: _**"autenticacao"**_)  
https://github.com/eithiagodias/fiap-notes/tree/autenticacao
1) git clone;
2) npm i;
3) npm run dev;
4) acesso ao front no navegador:  http://localhost:3001
  


#### Github do back:  
https://github.com/gimunaretto/autenticacao

1) git clone;
2) obs: usando JAVA 8 + MAVEN + SPRINGBOOT;
3) Rodar a aplicação;
4) Acesso pelo swagger:   
  http://localhost:9090/swagger-ui/index.html
5) API's:

- Cria o Usuário (retorna token ao criar):  

      POST/api/loginValidator/login (header: login/passw)  

- Faz o login do usuário  (retorna token ao logar):

      GET/api/loginValidator/login


**OBS**: _Rodar as duas aplicações ao mesmo tempo_
