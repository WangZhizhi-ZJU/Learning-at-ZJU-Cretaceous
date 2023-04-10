/*
 * Copyright (c) 2023, 2023, Everything-in-ZJU Group and/or its affiliates. All rights reserved.
 * Written by Wang Zhizhi, ISEE, Zhejiang University.
 * For the project Learning in ZJU Plus.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

/*
 * Allow remote connections.
 *  use mysql;
 *  update user set host = '%' where user = 'root';
 *  flush privileges;
 */

drop database if exists kernel_data_lizp;
create database kernel_data_lizp character set utf8mb4 collate utf8mb4_0900_ai_ci;
use kernel_data_lizp;

create table college_data_lizp (
    collegeID           varchar(3) not null unique,
    collegeName         varchar(255) not null unique,
    primary key (collegeID, collegeName)
);

insert into college_data_lizp values('000', '教务处');
insert into college_data_lizp values('061', '数学科学学院');
insert into college_data_lizp values('111', '信息与电子工程学院');
insert into college_data_lizp values('211', '计算机科学与技术学院');
insert into college_data_lizp values('551', '马克思主义学院');

create table major_data_lizp (
    majorID             varchar(6) not null,
    majorName           varchar(20) not null,
    collegeID           varchar(3) not null,
    primary key (majorID),
    constraint fk_major_college foreign key major_data_lizp(collegeID) references college_data_lizp(collegeID)
);

insert into major_data_lizp values('111000', '信息工程', '111');
insert into major_data_lizp values('111001', '电子科学与技术', '111');
insert into major_data_lizp values('211000', '计算机科学与技术', '211');
insert into major_data_lizp values('211001', '网络安全', '211');
insert into major_data_lizp values('211002', '软件工程', '211');

create table major_class_data_lizp (
    majorClassID        varchar(10) not null,
    majorClassName      varchar(20) not null,
    majorID             varchar(6) not null,
    primary key (majorClassID),
    constraint fk_major_class foreign key major_class_data_lizp(majorID) references major_data_lizp(majorID)
);

insert into major_class_data_lizp values('1110002005', '信息工程2005班', '111000');
insert into major_class_data_lizp values('2110002001', '计算机科学与技术2001班', '211000');
insert into major_class_data_lizp values('2110022007', '软件工程2007班', '211002');

create table course_type_data_lizp (
    courseTypeID        varchar(6) not null unique,
    courseTypeName      varchar(255) not null unique,
    primary key (courseTypeID, courseTypeName)
);

insert into course_type_data_lizp values('000000', '通用课程类');
insert into course_type_data_lizp values('061000', '数学类');
insert into course_type_data_lizp values('111000', '电工电子类');
insert into course_type_data_lizp values('111001', '通信类');
insert into course_type_data_lizp values('111002', '信息类');
insert into course_type_data_lizp values('211000', '计算机类');
insert into course_type_data_lizp values('551000', '思政类');

create table course_base_data_lizp (
    courseBaseID        varchar(8),
    courseName          varchar(255) not null,
    courseTypeID        varchar(6) not null default '000000',
    collegeID           varchar(3) not null default '000',
    courseCredit        decimal(3, 1) not null default 2.0,
    unavailable         int not null default 0,
    description         text,
    primary key (courseBaseID),
    constraint fk_course_base_course_type foreign key course_base_data_lizp(courseTypeID) references course_type_data_lizp(courseTypeID),
    constraint fk_course_base_college foreign key course_base_data_lizp(collegeID) references college_data_lizp(collegeID)
);

insert into course_base_data_lizp values('21121830', '计算机系统Ⅰ', '211000', '211', 5.5, 0, '《计算机系统I》是计算机系统类的核心基础课程，以计算机专业的两门核心专业课程《数字逻辑》和《计算机组成》为基础，从信息安全实践出发重新设计和组织内容。本课程是《计算机系统II》和《计算机系统III》的基础和前导。课程目的是使学生获得计算机逻辑电路设计和计算机组成方面的基本理论、知识和实验技能，为深入学习计算机操作系统、体系结构、系统安全、硬件安全等专业课程奠定基础。要求总体上具备对计算机系统和程序执行的基本理解，掌握门电路、触发器及常用逻辑器件、组合电路和时序电路的基本概念和设计使用方法，初步掌握运用硬件描述语言进行简单数字小系统的设计方法。课程还包括RISC-V指令集、寻址模式、数据类型和汇编语言编程、处理器微结构（数据通路和控制信号）等相关知识的学习，使得学生具有设计和实现单时钟周期处理器的初步能力。');
insert into course_base_data_lizp values('21121840', '计算机系统Ⅱ', '211000', '211', 5.5, 0, '《计算机系统II》主干内容为操作系统原理与基于RISC-V的操作系统内核设计，同时与《计算机系统I》和《计算机系统III》深入融合。传统“操作系统”课程和数字逻辑，计算机组成和计算机体系被分割成不同的课程。不同课程的内容容易存在衔接不当的问题，导致部分关键内容缺失、重复，让学生无法将计算机系统作为一个整体来理解。因此计算机系统II着眼于与计算机系统I和III将系统作为整理来授课，内容深度融合，弥补知识的缺失和从去掉知识的重复，让学生对计算机系统有一个整体概念。');
insert into course_base_data_lizp values('21121850', '计算机系统Ⅲ', '211000', '211', 5.5, 0, '《计算机系统III》是计算机系统类课程中的一门重要的专业课，它强调从总体结构、系统分析角度来研究计算机系统，培养学生深入理解和掌握计算机系统的设计方法，同时能够权衡计算机性能、成本与功耗之间的关系。在已具备计算机软、硬件知识的基础上，从计算机系统角度出发介绍计算机软、硬件总体设计的基本原理与设计方法，使学生建立计算机系统的整体概念，为设计、开发计算机系统打下基础，学会设计一个复杂的系统应该从何处入手。教学过程按照由浅入深、由整体到局部的思路，从计算机体系结构有关的基本概念入手，逐步对指令集设计、流水线实现、指令级并行、动态优化方法、存储器设计等各个具体的系统设计与实现方法进行介绍。在学习理论同时，熟悉硬件设计工具和环境，掌握硬件设计开发方法，能够自主设计实现支持基于RISC-V指令集的最小系统（实现完整的流水处理器并支持加载运行操作系统），完成在FPGA板上的正确性验证与性能测试。');
insert into course_base_data_lizp values('21121960', '脑启发人工智能导论', '211000', '211', 4.0, 0, '本课程是脑启发人工智能（类脑计算）的入门课程，包含了计算神经科学、脑科学和人工智能及其他基础科学等多学科的交叉和融合。首先介绍脑启发人工智能的基本概念、历史和发展现况，进一步讲解基于大脑结构和信息处理机制的神经元、突触以及由神经元和突触构成的网络模型和多脑区模型，最后介绍相关的计算模型和算法。课程将从生物神经元模型和信息处理机制、大脑的结构和功能组织、感知原理及模型、学习机制及学习算法、脉冲神经网络的概念、类脑人工智能算法与应用等方面进行展开，旨在加深同学对脑启发人工智能的理解。通过这门课程的学习，学生应该掌握脑启发的神经元、神经网络和人工智能算法，同时启发同学们对新一代脑启发人工智能理论、模型和应用的探索，培养掌握新一代人工智能方法和技术的专业人才。');
insert into course_base_data_lizp values('211G0050', 'Linux应用技术基础', '211000', '211', 2.0, 0, '本课程主要介绍Linux操作系统的安装、命令使用和系统管理。包括Linux的文件和文件系统结构，进程概念和管理，文件安全和共享，I/O重定向和管道，以及各种实用软件的使用，shell程序设计，Linux系统程序设计初步。');
insert into course_base_data_lizp values('211R0030', 'Python程序设计（H）', '211000', '211', 3.0, 0, '通过介绍Python语言及其编程技术，包括数据的定义、运算及流程控制、程序结构和函数、常用算法和程序设计方法和风格等内容，使学生了解高级程序设计语言的结构，掌握基本的程序设计过程和技巧。本课程以数据科学要求为依据，掌握利用计算机求解简单的大数据问题，初步具备数据科学程序设计能力。');
insert into course_base_data_lizp values('211G0220', 'Java程序设计', '211000', '211', 3.0, 0, 'Java语言是一种面向对象的程序设计语言。通过介绍Java语言及其编程技术，包括数据的定义、运算及流程控制、程序结构和方法、数据的输入和输出、类的定义、类的继承、常用算法和程序设计方法和风格等内容，使学生了解高级程序设计语言的结构，了解面向对象的程序设计，掌握基本的程序设计过程和技巧，掌握基本的分析问题和利用计算机求解问题的能力，具备初步的高级语言程序设计能力。');

create table student_account_data_lizp (
    accountID           varchar(10) not null unique,
    accountName         varchar(255) not null unique,
    password            varchar(255) not null,
    avatar              varchar(255),
    name                varchar(255) not null,
    phone               varchar(11) not null unique,
    personalID          varchar(18) not null unique,
    gender              int,
    collegeID           varchar(3) not null,
    majorID             varchar(6) not null,
    majorClassID        varchar(10) not null,
    joinDate            datetime,
    birthDate           datetime,
    region              varchar(50),
    primary key (accountID, accountName),
    constraint fk_student_college foreign key student_account_data_lizp(collegeID) references college_data_lizp(collegeID),
    constraint fk_student_major foreign key student_account_data_lizp(majorID) references major_data_lizp(majorID),
    constraint fk_student_major_class foreign key student_account_data_lizp(majorClassID) references major_class_data_lizp(majorClassID)
);

insert into student_account_data_lizp values ('3200100001', '3200100001@zju.edu.cn', '8e04b93e289717d2c507a4fdb952cb5d3306f94b2fc37f170a39d0b238747ef8', 'http://localhost/service/common/get-avatar/3200100001', '彭鹏', 13306516666, 330181200201010001, 1, '111', '111000', '1110002005', '2020-09-01', '2002-01-03', '浙江省杭州市');

create table teacher_account_data_lizp (
    accountID           varchar(10) not null unique,
    accountName         varchar(255) not null unique,
    password            varchar(255) not null,
    avatar              varchar(255) not null,
    name                varchar(255) not null,
    phone               varchar(11) not null unique,
    personalID          varchar(18) not null unique,
    gender              int,
    collegeID           varchar(3) not null,
    joinDate            datetime,
    professionalTitle   varchar(20),
    region              varchar(50),
    primary key (accountID, accountName),
    constraint fk_teacher_college foreign key teacher_account_data_lizp(collegeID) references college_data_lizp(collegeID)
);

insert into teacher_account_data_lizp values ('2010000001', '2010000001@zju.edu.cn', '3d2256a949996f9f4b64b2a401c502ce0db227b8e90aaaa6d86331ffb5176a8d', 'http://localhost/service/common/get-avatar/2010000001', '王建江', 18902017742, 330181198806130031, 1, '211', '2001-08-24', '教授', '浙江省杭州市');

create table administrator_account_data_lizp (
    accountID           varchar(10) not null unique,
    accountName         varchar(255) not null unique,
    password            varchar(255) not null,
    name                varchar(255) not null,
    primary key (accountID, accountName)
);

insert into administrator_account_data_lizp values ('1000000001', '1000000001@zju.edu.cn', '80a7cd0ffb78b364089257b612609ae24a9e886a2513ee0b3a7dc67b828c8c3c', '蔡徐坤');

create table course_data_lizp (
    courseID            varchar(32),
    courseBaseID        varchar(8),
    courseName          varchar(255) not null,
    courseTypeID        varchar(6) not null default '000000',
    collegeID           varchar(3) not null default '000',
    courseCredit        decimal(3, 1) not null default 2.0,
    teacherID           varchar(10) not null,
    studentsLimit       int not null default 50,
    state               int not null,
    academicYear        int not null,
    semester            int not null,
    description         text,
    primary key (courseID),
    constraint fk_course_course_base foreign key course_data_lizp(courseBaseID) references course_base_data_lizp(courseBaseID),
    constraint fk_course_course_type foreign key course_data_lizp(courseTypeID) references course_type_data_lizp(courseTypeID),
    constraint fk_course_college foreign key course_data_lizp(collegeID) references college_data_lizp(collegeID),
    constraint fk_course_teacher foreign key course_data_lizp(teacherID) references teacher_account_data_lizp(accountID)
);

insert into course_data_lizp values ('(2022-2023-1)-21121960-0000001-1', '21121960', '脑启发人工智能导论', '211000', '211', 4.0, '2010000001', 80, 0, 2022, 1, '本课程是脑启发人工智能（类脑计算）的入门课程，包含了计算神经科学、脑科学和人工智能及其他基础科学等多学科的交叉和融合。首先介绍脑启发人工智能的基本概念、历史和发展现况，进一步讲解基于大脑结构和信息处理机制的神经元、突触以及由神经元和突触构成的网络模型和多脑区模型，最后介绍相关的计算模型和算法。课程将从生物神经元模型和信息处理机制、大脑的结构和功能组织、感知原理及模型、学习机制及学习算法、脉冲神经网络的概念、类脑人工智能算法与应用等方面进行展开，旨在加深同学对脑启发人工智能的理解。通过这门课程的学习，学生应该掌握脑启发的神经元、神经网络和人工智能算法，同时启发同学们对新一代脑启发人工智能理论、模型和应用的探索，培养掌握新一代人工智能方法和技术的专业人才。');

select max(accountID) from student_account_data_lizp where accountID regexp '32002.....';