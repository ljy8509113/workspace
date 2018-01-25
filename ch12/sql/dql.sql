--SELECT * FROM emp;
SELECT empno, ename, sal FROM emp WHERE deptno = 10;

SELECT ename, hiredate, deptno FROM emp WHERE empno =7369;

SELECT * from emp where ename="ALLEN";

--입사일이 81/12/03인 사원들의 이름, 부서번호, 월급, 입사일을 출력
select ename, deptno, sal, hiredate from emp where hiredate='1981-12-03'

--입사일이 1981/12/31 이후에 입사한 사원의 정보를 최근 입사한 직원 순서대로 출력
select * from emp where hiredate >= '1981-12-31' order by hiredate desc;

--급여가 800 이상인 직원의 이름, 급여, 부서번호를 급여가 작은 순서대로 출력
select ename, sal, deptno from emp where sal >= 800 order by sal asc;

--부서번호가 20번 이상인 사원의 모든 정보를 부서번호가 작은 순서대로 출력
select * from emp where deptno >=20 order by deptno asc;

--입사일이 81년 하반기에 입사한 사원의 이름, 월급, 입사일을 입사한 순서대로 출력
select ename, sal, hiredate from emp where hiredate between '1981-07-01' AND '1981-12-31' order by hiredate asc;

--급여가 1600 보다 크고 3000보다 작은 직원의 이름, 직무, 급여를 출력
select ename, job, sal from emp where sal>1600 && sal<3000;


--사원번호가 7654와 7782사이 이외의 사원의 모든 정보를 출력


--이름이 k로 시작하는 직원들보다 높은 이름을 가진 직원의 모든 정보를 출력 k로 시작하는 직원의 이름도 제외
select * from emp where ename>="L%";
--이름이 b와 j사이의 모든 사원의 정보를 출력
select * from emp where ename >= 'B%' AND ename <'J%';
--입사일이 81년 이외에 입사한 직원의 모든 정보를 출력
select * from emp where hiredate <'1981-01-01' or hiredate > '1981-12-31';

--직무가 MANAGER 와 SALESMAN인 직원의 모든 정보를 출력
select * from emp where job='MANAGER' or job='SALESMAN';
--이름이 s로 시작하는 사원의 사원번호. 이름. 입사일 부서번호 출력
select empno, ename, hiredate, deptno from emp where ename like 'S%';
--입사일이82년도인 직원의 모든 정보를 출력
select * from emp where hiredate between '1982-01-01' and '1982-12-31';
--이름 중 대소문자 구분 없이 s 가 들어있는 직원의 모든정보
select * from emp where ename like '%S%' or '%s%';

--이름이 S로 시작하고 마지막 글자가 T인 직원의 정보(이름은5글자)
select * from emp where ename like 'S%T' AND LENGTH(ename) <=5;
select * from emp where ename like 'S___T';

--첫번째 문자는 관계없고 두번째 문자가 A인 직원의 모든정보
select * from emp where ename like '_A%';

--성과급이 null 인 직원
select * from emp where comm is null;

--성과급이 null 이 아닌 직원의 정보
select * from emp where comm is not null;

--성과급이 null 이 아니고 0이 아닌 직원의 정보를 출력
select * from emp where comm is not null and comm != 0;

--부서가 30번 부서원 중에서 급여가 1500 이상인 직원의 이름, 부서, 월급을 출력
select ename, deptno, sal  from emp where deptno = 30 and sal >= 1500;

--이름의 첫글자가 k로 시작하거나 부서 번호가 30인 직원의 사원번호 이름 부서번호 출력
select ename, deptno, empno from emp where ename like 'K%' or deptno = 30;

--급여가 1500 이상이고 부서 번호가 30번인 사원중 직무가 MANAGER인 직원의 모든 정보를 출력
select * from emp where sal >= 1500 and deptno = 30 and job = 'MANAGER';

--부서 번호가 30인 직원의 모든정보를 사원번호에 대하여 오름차순 정렬
select * from emp where deptno = 30 order by empno asc;

--부서 번호로 내림차순 이름순으로 오름차순 급여순으로 내림차순
select * from emp order by deptno desc, ename asc, sal desc;

--부서 번호와 그 부서에 속한 사원들의 급여액 합계를 보이시오.
select deptno, SUM(sal) from emp group by deptno;

--가장 많은 급여를 받는 사원의 급여액과 가장 적은 급여를 받는 사원의 급여액을 보이시오.
select deptno, MAX(sal), MIN(sal) from emp group by deptno;

--가장 많은 급여를 받는 사원의 이름을 보이시오.
select ename, sal from emp where sal = (select MAX(sal) from emp);

--사원들의 현재 급여와 급여를 10%인상했을 때의 예상 급여를 보이시오.
select ename, sal, sal * 1.1 from emp;

--모든 사원들의 이름과 부서 이름을 보이시오
select emp.ename, dept.dname from emp, dept where emp.deptno = dept.deptno;
select e.ename, d.dname from emp e, dept d where e.deptno = d.deptno;

--SMITH 사원이 속한 부서의 위치
select e.ename, d.dname, d.loc from emp e, dept d where e.ename = 'SMITH'; 

--사원의 이름과 그 사원의 상사 이름을 보이시오
select e.ename, m.ename from emp e, emp m where e.mgr = m.empno;

