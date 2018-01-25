--SELECT * FROM emp;
SELECT empno, ename, sal FROM emp WHERE deptno = 10;

SELECT ename, hiredate, deptno FROM emp WHERE empno =7369;

SELECT * from emp where ename="ALLEN";

--�Ի����� 81/12/03�� ������� �̸�, �μ���ȣ, ����, �Ի����� ���
select ename, deptno, sal, hiredate from emp where hiredate='1981-12-03'

--�Ի����� 1981/12/31 ���Ŀ� �Ի��� ����� ������ �ֱ� �Ի��� ���� ������� ���
select * from emp where hiredate >= '1981-12-31' order by hiredate desc;

--�޿��� 800 �̻��� ������ �̸�, �޿�, �μ���ȣ�� �޿��� ���� ������� ���
select ename, sal, deptno from emp where sal >= 800 order by sal asc;

--�μ���ȣ�� 20�� �̻��� ����� ��� ������ �μ���ȣ�� ���� ������� ���
select * from emp where deptno >=20 order by deptno asc;

--�Ի����� 81�� �Ϲݱ⿡ �Ի��� ����� �̸�, ����, �Ի����� �Ի��� ������� ���
select ename, sal, hiredate from emp where hiredate between '1981-07-01' AND '1981-12-31' order by hiredate asc;

--�޿��� 1600 ���� ũ�� 3000���� ���� ������ �̸�, ����, �޿��� ���
select ename, job, sal from emp where sal>1600 && sal<3000;


--�����ȣ�� 7654�� 7782���� �̿��� ����� ��� ������ ���


--�̸��� k�� �����ϴ� �����麸�� ���� �̸��� ���� ������ ��� ������ ��� k�� �����ϴ� ������ �̸��� ����
select * from emp where ename>="L%";
--�̸��� b�� j������ ��� ����� ������ ���
select * from emp where ename >= 'B%' AND ename <'J%';
--�Ի����� 81�� �̿ܿ� �Ի��� ������ ��� ������ ���
select * from emp where hiredate <'1981-01-01' or hiredate > '1981-12-31';

--������ MANAGER �� SALESMAN�� ������ ��� ������ ���
select * from emp where job='MANAGER' or job='SALESMAN';
--�̸��� s�� �����ϴ� ����� �����ȣ. �̸�. �Ի��� �μ���ȣ ���
select empno, ename, hiredate, deptno from emp where ename like 'S%';
--�Ի�����82�⵵�� ������ ��� ������ ���
select * from emp where hiredate between '1982-01-01' and '1982-12-31';
--�̸� �� ��ҹ��� ���� ���� s �� ����ִ� ������ �������
select * from emp where ename like '%S%' or '%s%';

--�̸��� S�� �����ϰ� ������ ���ڰ� T�� ������ ����(�̸���5����)
select * from emp where ename like 'S%T' AND LENGTH(ename) <=5;
select * from emp where ename like 'S___T';

--ù��° ���ڴ� ������� �ι�° ���ڰ� A�� ������ �������
select * from emp where ename like '_A%';

--�������� null �� ����
select * from emp where comm is null;

--�������� null �� �ƴ� ������ ����
select * from emp where comm is not null;

--�������� null �� �ƴϰ� 0�� �ƴ� ������ ������ ���
select * from emp where comm is not null and comm != 0;

--�μ��� 30�� �μ��� �߿��� �޿��� 1500 �̻��� ������ �̸�, �μ�, ������ ���
select ename, deptno, sal  from emp where deptno = 30 and sal >= 1500;

--�̸��� ù���ڰ� k�� �����ϰų� �μ� ��ȣ�� 30�� ������ �����ȣ �̸� �μ���ȣ ���
select ename, deptno, empno from emp where ename like 'K%' or deptno = 30;

--�޿��� 1500 �̻��̰� �μ� ��ȣ�� 30���� ����� ������ MANAGER�� ������ ��� ������ ���
select * from emp where sal >= 1500 and deptno = 30 and job = 'MANAGER';

--�μ� ��ȣ�� 30�� ������ ��������� �����ȣ�� ���Ͽ� �������� ����
select * from emp where deptno = 30 order by empno asc;

--�μ� ��ȣ�� �������� �̸������� �������� �޿������� ��������
select * from emp order by deptno desc, ename asc, sal desc;

--�μ� ��ȣ�� �� �μ��� ���� ������� �޿��� �հ踦 ���̽ÿ�.
select deptno, SUM(sal) from emp group by deptno;

--���� ���� �޿��� �޴� ����� �޿��װ� ���� ���� �޿��� �޴� ����� �޿����� ���̽ÿ�.
select deptno, MAX(sal), MIN(sal) from emp group by deptno;

--���� ���� �޿��� �޴� ����� �̸��� ���̽ÿ�.
select ename, sal from emp where sal = (select MAX(sal) from emp);

--������� ���� �޿��� �޿��� 10%�λ����� ���� ���� �޿��� ���̽ÿ�.
select ename, sal, sal * 1.1 from emp;

--��� ������� �̸��� �μ� �̸��� ���̽ÿ�
select emp.ename, dept.dname from emp, dept where emp.deptno = dept.deptno;
select e.ename, d.dname from emp e, dept d where e.deptno = d.deptno;

--SMITH ����� ���� �μ��� ��ġ
select e.ename, d.dname, d.loc from emp e, dept d where e.ename = 'SMITH'; 

--����� �̸��� �� ����� ��� �̸��� ���̽ÿ�
select e.ename, m.ename from emp e, emp m where e.mgr = m.empno;

