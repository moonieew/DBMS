USE [master]
GO
/****** Object:  Database [ShopTheThao2]    Script Date: 18/11/2021 9:36:58 PM ******/
CREATE DATABASE [ShopTheThao2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ShopTheThao2', FILENAME = N'E:\SQL\MSSQL15.SQLEXPRESS\MSSQL\DATA\ShopTheThao2.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ShopTheThao2_log', FILENAME = N'E:\SQL\MSSQL15.SQLEXPRESS\MSSQL\DATA\ShopTheThao2_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [ShopTheThao2] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ShopTheThao2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ShopTheThao2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ShopTheThao2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ShopTheThao2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ShopTheThao2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ShopTheThao2] SET ARITHABORT OFF 
GO
ALTER DATABASE [ShopTheThao2] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ShopTheThao2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ShopTheThao2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ShopTheThao2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ShopTheThao2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ShopTheThao2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ShopTheThao2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ShopTheThao2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ShopTheThao2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ShopTheThao2] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ShopTheThao2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ShopTheThao2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ShopTheThao2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ShopTheThao2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ShopTheThao2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ShopTheThao2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ShopTheThao2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ShopTheThao2] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ShopTheThao2] SET  MULTI_USER 
GO
ALTER DATABASE [ShopTheThao2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ShopTheThao2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ShopTheThao2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ShopTheThao2] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ShopTheThao2] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ShopTheThao2] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [ShopTheThao2] SET QUERY_STORE = OFF
GO
USE [ShopTheThao2]
GO
/****** Object:  UserDefinedFunction [dbo].[Func_CheckLogin]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_CheckLogin] (
	@username nvarchar(50), 
	@password nvarchar(50))
RETURNS int
AS
BEGIN
		DECLARE @flag int
		IF EXISTS (SELECT * FROM [User] WHERE username=@username AND password = @password)
			RETURN 1
		ELSE
			RETURN 0
		RETURN 0
END
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[createAt] [date] NULL,
	[completedAt] [date] NULL,
	[status] [int] NULL,
	[quantity] [int] NULL,
	[shipping] [float] NOT NULL,
	[total] [float] NOT NULL,
	[grandtotal] [float] NOT NULL,
	[userid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[Func_CheckOrder]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_CheckOrder] (@userid int, @status int)
RETURNS table AS
	RETURN SELECT * FROM [Orders] WHERE userid = @userid AND status = @status
GO
/****** Object:  Table [dbo].[Product]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[saleprice] [float] NULL,
	[quantity] [int] NULL,
	[description] [nvarchar](200) NOT NULL,
	[image] [nvarchar](200) NOT NULL,
	[brandid] [int] NOT NULL,
	[categoryid] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[Func_pagingProductBySearch]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_pagingProductBySearch] (@pageNumber int, @rowsOfPage int, @search nvarchar(50))
RETURNS TABLE
AS
RETURN
(
    SELECT * FROM Product
	WHERE CONCAT(id,[name]) like @search
	ORDER BY id
	OFFSET (@pageNumber-1)*@rowsOfPage ROWS
	FETCH NEXT @rowsOfPage ROWS ONLY
)
GO
/****** Object:  Table [dbo].[Category]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[view_Categories]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[view_Categories]
AS
SELECT * FROM Category
GO
/****** Object:  Table [dbo].[Brand]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Brand](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[view_Brands]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[view_Brands]
AS
SELECT * FROM Brand
GO
/****** Object:  Table [dbo].[User]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[fname] [nvarchar](50) NOT NULL,
	[lname] [nvarchar](50) NOT NULL,
	[gender] [int] NULL,
	[phone] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[roleid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[Func_pagingUser]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_pagingUser](@pageNumber int, @rowsOfPage int)
RETURNS TABLE
AS
RETURN
(
    SELECT * FROM [User]
	ORDER BY id 
	OFFSET (@pageNumber-1)*@rowsOfPage ROWS
	FETCH NEXT @rowsOfPage ROWS ONLY
)
GO
/****** Object:  UserDefinedFunction [dbo].[Func_pagingAllProduct]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_pagingAllProduct](@pageNumber int, @rowsOfPage int)
RETURNS TABLE
AS
RETURN
(
    SELECT * FROM Product
	ORDER BY id 
	OFFSET (@pageNumber-1)*@rowsOfPage ROWS
	FETCH NEXT @rowsOfPage ROWS ONLY
)
GO
/****** Object:  UserDefinedFunction [dbo].[Func_pagingProductByCategoryId]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_pagingProductByCategoryId] (@pageNumber int, @rowsOfPage int, @categoryId int)
RETURNS TABLE
AS
RETURN
(
    SELECT * FROM Product
	WHERE categoryid = @categoryId
	ORDER BY id
	OFFSET (@pageNumber-1)*@rowsOfPage ROWS
	FETCH NEXT @rowsOfPage ROWS ONLY
)
GO
/****** Object:  Table [dbo].[Carts]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[status] [int] NULL,
	[quantity] [int] NULL,
	[shipping] [float] NOT NULL,
	[total] [float] NOT NULL,
	[grandtotal] [float] NOT NULL,
	[userid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[Func_GetCart]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_GetCart] (@userid int)
RETURNS table AS
	RETURN SELECT * FROM [Carts] WHERE userid = @userid;
GO
/****** Object:  Table [dbo].[CartDetail]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CartDetail](
	[productid] [int] NOT NULL,
	[cartid] [int] NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[productid] ASC,
	[cartid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[Func_GetCartDetail]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_GetCartDetail] (@cartid int)
RETURNS table AS
	RETURN SELECT * FROM [CartDetail] WHERE cartid = @cartid
GO
/****** Object:  UserDefinedFunction [dbo].[Func_count]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_count] (@categoryid int, @search nvarchar(50))
RETURNS TABLE
AS
RETURN
SELECT DISTINCT  (
        SELECT COUNT(*)
        FROM [User]
        ) AS CountUser,
        (
        SELECT COUNT(*)
        FROM Product
        ) AS CountAllProduct,
		(SELECT COUNT(*)
		FROM Product WHERE categoryid = @categoryid) AS CountByCategory,
		(SELECT COUNT(*)
        FROM Product WHERE CONCAT(id,[name]) like @search ) AS CountBySearch
FROM  [User],Product
GO
/****** Object:  UserDefinedFunction [dbo].[Func_GetOrder]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_GetOrder] (@userid int)
RETURNS TABLE
AS
RETURN
SELECT * FROM Orders WHERE userid = @userid
GO
/****** Object:  UserDefinedFunction [dbo].[Func_GetNewId]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Func_GetNewId] (@userid int)
RETURNS TABLE
AS
RETURN
	SELECT MAX(id) AS MAXID FROM Orders WHERE userid = @userid
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[productid] [int] NOT NULL,
	[orderid] [int] NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[productid] ASC,
	[orderid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Brand] ON 

INSERT [dbo].[Brand] ([id], [name], [description]) VALUES (4, N'Adidas', N'Adidas là thương hiệu thể thao lâu đời')
INSERT [dbo].[Brand] ([id], [name], [description]) VALUES (5, N'Nike', N'Nike là một trong những thương hiệu thể thao nổi tiếng nhất trên thế giới')
INSERT [dbo].[Brand] ([id], [name], [description]) VALUES (6, N'Puma', N'Puma là hiệu thể thao nổi tiếng với các mẫu thiết kế đẹp')
SET IDENTITY_INSERT [dbo].[Brand] OFF
GO
INSERT [dbo].[CartDetail] ([productid], [cartid], [price], [quantity]) VALUES (7, 11, 2800000, 4)
INSERT [dbo].[CartDetail] ([productid], [cartid], [price], [quantity]) VALUES (9, 11, 2000000, 5)
INSERT [dbo].[CartDetail] ([productid], [cartid], [price], [quantity]) VALUES (12, 11, 4900000, 1)
INSERT [dbo].[CartDetail] ([productid], [cartid], [price], [quantity]) VALUES (13, 11, 840000, 1)
INSERT [dbo].[CartDetail] ([productid], [cartid], [price], [quantity]) VALUES (14, 2, 1100000, 2)
GO
SET IDENTITY_INSERT [dbo].[Carts] ON 

INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (1, NULL, 0, 0, 0, 0, 7)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (2, NULL, 2, 30000, 1800000, 1830000, 8)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (3, NULL, 0, 0, 0, 0, 12)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (4, NULL, 0, 0, 0, 0, 13)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (5, NULL, 0, 0, 0, 0, 14)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (6, NULL, 0, 0, 0, 0, 15)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (7, NULL, 0, 0, 0, 0, 17)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (8, NULL, 0, 0, 0, 0, 18)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (9, NULL, 0, 0, 0, 0, 19)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (11, NULL, 4, 30000, 10540000, 10570000, 23)
INSERT [dbo].[Carts] ([id], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (12, NULL, 0, 0, 0, 0, 25)
SET IDENTITY_INSERT [dbo].[Carts] OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([id], [name]) VALUES (4, N'Áo Thể Thao')
INSERT [dbo].[Category] ([id], [name]) VALUES (5, N'Quần Thể Thao')
INSERT [dbo].[Category] ([id], [name]) VALUES (6, N'Giày Thể Thao')
INSERT [dbo].[Category] ([id], [name]) VALUES (7, N'Phụ Kiện')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
INSERT [dbo].[OrderDetail] ([productid], [orderid], [price], [quantity]) VALUES (2, 1, 400, 1)
INSERT [dbo].[OrderDetail] ([productid], [orderid], [price], [quantity]) VALUES (2, 2, 400, 1)
INSERT [dbo].[OrderDetail] ([productid], [orderid], [price], [quantity]) VALUES (2, 3, 400, 1)
INSERT [dbo].[OrderDetail] ([productid], [orderid], [price], [quantity]) VALUES (7, 1, 700000, 1)
INSERT [dbo].[OrderDetail] ([productid], [orderid], [price], [quantity]) VALUES (9, 2, 450000, 1)
INSERT [dbo].[OrderDetail] ([productid], [orderid], [price], [quantity]) VALUES (9, 3, 450000, 1)
INSERT [dbo].[OrderDetail] ([productid], [orderid], [price], [quantity]) VALUES (11, 1, 4950000, 1)
INSERT [dbo].[OrderDetail] ([productid], [orderid], [price], [quantity]) VALUES (11, 3, 4950000, 1)
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([id], [createAt], [completedAt], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (1, CAST(N'2021-11-18' AS Date), NULL, 1, 3, 0, 5650400, 5650400, 14)
INSERT [dbo].[Orders] ([id], [createAt], [completedAt], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (2, CAST(N'2021-11-18' AS Date), NULL, 1, 1, 0, -949600, -949600, 14)
INSERT [dbo].[Orders] ([id], [createAt], [completedAt], [status], [quantity], [shipping], [total], [grandtotal], [userid]) VALUES (3, CAST(N'2021-11-18' AS Date), NULL, 1, 3, 0, 5400400, 5400400, 14)
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (2, N'Áo Tennis Polo', 800, 400, 100, N'Play your own game. This AEROREADY tennis polo shirt absorbs moisture to help you find your groove. Mesh panels shoulder and side panels increase airflow and reduce towel breaks', N'https://cf.shopee.vn/file/87f7ef5da07be489a524c744b2b25f81', 4, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (7, N'Nike Pro Dri-FIT ADV', 700000, 0, 50, N'The Nike Pro Dri-FIT ADV Top keeps you dry and cool as you move through the heat of your most challenging workouts or competitions', N'https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,b_rgb:f5f5f5/bdebc7f7-0267-4dd2-b537-d828f362697a/pro-dri-fit-adv-short-sleeve-top-TBPNdk.png', 5, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (9, N'Quần TRAINING Primeblue', 500000, 50000, 50, N'Hit workout goals and roll through to-do lists without skipping a beat in these shorts', N'https://cf.shopee.vn/file/c3c4139bf8f946a2ed3f0f2b77a5781b', 4, 5)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (10, N'Quần Essentials Open Hem Embroidered', 800000, 30000, 50, N'Slide on these cosy pants and you''re signing up for a full day of comfort. An elastic waist and drawcord keep things in place and casual', N'https://cf.shopee.vn/file/24277ed786ab774cd6b6bb48fa41b643', 4, 5)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (11, N'Giày RUNNING Ultraboost 21', 5000000, 50000, 50, N'Prototype after prototype. Innovation after innovation. Testing after testing.', N'https://cf.shopee.vn/file/e6730e83b20bed14749f12130c3379e7', 4, 6)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (12, N'Giày RUNNING Ultraboost 5 DNA', 5000000, 100000, 60, N'This version of the adidas Ultraboost Shoes are for people who enjoy the beach but also keep its interests at heart', N'https://cf.shopee.vn/file/5a727cf7022dd00ad077c0f5fc3f168d', 4, 6)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (13, N'Áo ORIGINALS Adicolor', 850000, 10000, 50, N'Play favourites, even with your basics. This adidas t-shirt has all the prime details. Signature Trefoil logos, front and back', N'https://cf.shopee.vn/file/bf38717d17ece472a06c39c4b27ea2ba', 4, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (14, N'Quần Fast Split Shorts', 550000, 0, 30, N'Faster today. Faster tomorrow. Aim for progress every time you run in these adidas running shorts', N'https://cf.shopee.vn/file/fb1b2a783b08ae39e0320447425cde3c', 4, 5)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (15, N'Áo Nike DRI-FIT VICTORY GOLF POLO', 1000000, 50000, 40, N'ÁO NIKE DRI-FIT VICTORY GOLF POLO CHÍNH HÃNG (BV0354-100)', N'https://cf.shopee.vn/file/c55eea176b6ef749772686a797c6a4a5', 5, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (16, N'Giày Puma RS-Z', 2500000, 100000, 30, N'This new addition to the RS family features a sleek silhouette accented with bold cold', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/381640/05/sv01/fnd/PNA/fmt/png/RS-Z-Sneakers', 6, 6)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (17, N'Giày Puma RS-Z Orange Campus', 2500000, 300000, 20, N'This fashion-forward footwear flaunts a winning combo of a bold silhouette', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/383645/01/fnd/PNA/fmt/png/RS-Z-Orange-Campus', 6, 6)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (18, N'Giày Puma RS-X Toys', 2500000, 200000, 40, N'X marks extreme. Exaggerated. Remixed', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/374371/01/sv01/fnd/PNA/fmt/png/RS-X-Toys-Reinvention-Sneakers', 6, 6)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (19, N'Áo Puma Cloud 9', 800000, 0, 50, N'It''s made using cotton from the Better Cotton Initiative', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/532390/05/fnd/PNA/fmt/png/PUMA-x-CLOUD9-Graphic-Men''s-Esports-Tee', 6, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (20, N'Áo Puma Haribo', 700000, 0, 40, N'alling all gummy bear fanatics, the Haribo collection brings sweetness to everyday street style', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/532762/01/bv/fnd/PNA/fmt/png/PUMA-x-HARIBO-Printed-Tee', 6, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (21, N'Quần Puma Classic', 500000, 0, 40, N'Comfy meets cool in these laid-back sweatpants from the Classics collection', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/530090/01/mod01/fnd/PNA/fmt/png/Classics-Mens''-Cuffed-Sweatpants', 6, 5)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (22, N'Áo Puma Scuderia Ferrari Race', 1000000, 0, 40, N'Fanwear looks fierce in this perfect Scuderia Ferrari polo shirt.', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/531686/01/fnd/PNA/fmt/png/Scuderia-Ferrari-Race-Men''s-Polo-Shirt', 6, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (23, N'Áo Mercedes F1 Printed', 1100000, 50000, 50, N'We''ve injected the exciting world of Mercedes-AMG Petronas Motorsport into this pique polo shirt', N'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/531882/01/bv/fnd/PNA/fmt/png/Mercedes-F1-Printed-Men''s-Polo-Shirt', 6, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (24, N'Áo T-Shirt Basketball', 600000, 10000, 40, N'Ball is life. The Nike Basketball T-Shirt shows it with photorealistic graphics on soft, comfortable cotton', N'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/4c01606b-985a-44ae-8f8e-dcd4e90472bb/mens-basketball-t-shirt-bn5b4T.png', 5, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (25, N'Áo Nike Sportswear Premium Essential', 900000, 200000, 30, N'An embroidered chest graphic and woven flag label elevate the details.', N'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/ea90e626-a8cc-4a3c-8036-dabfc545829b/sportswear-premium-essential-mens-t-shirt-SS1mBB.png', 5, 4)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (26, N'Quần Nike Sportswear Club Fleece', 1100000, 100000, 30, N'Joggers combine a classic look with the soft comfort of fleece for an elevated', N'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/f55c97a4-40c2-4aca-acb7-c954fe8224ba/sportswear-club-fleece-joggers-KflRdQ.png', 4, 5)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (27, N'Quần Nike Sportswear Club Fleece 2', 1500000, 100000, 30, N'The Nike Sportswear Club Fleece Pants add a pair-with-anything tie-dye print to the soft comfort of fleece', N'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/53984111-f4d4-4d2d-8e17-bfbe446089b4/sportswear-club-fleece-mens-pants-tkTFzd.png', 5, 5)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (28, N'Giày Nike Air Jordan 1 Mid SE', 3000000, 0, 30, N'Ground your style in Flight with the Air Jordan 1 Mid, the sneaker of endless possibilities', N'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/e8804a4c-a868-4831-ade4-29f3eae0c358/air-jordan-1-mid-se-shoes-ZWx8QW.png', 5, 6)
INSERT [dbo].[Product] ([id], [name], [price], [saleprice], [quantity], [description], [image], [brandid], [categoryid]) VALUES (29, N'Giày Jordan Air NFH', 2300000, 100000, 30, N'Lightweight materials and an easy fit make it comfortable.', N'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/22fbb163-501d-4270-9b74-67b7023f644d/jordan-air-nfh-shoes-Ktzw9P.png', 5, 6)
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (7, N'minhnguyet', N'1234', N'Nguyệt', N'Lê Thị Minh', 1, N'09128371238', N'asdas@mail.com', N'TP Hồ Chí Minh', 2)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (8, N'luan', N'123', N'Luân', N'Minh', 0, N'0123', N'luan@gmail.com', N'123', 2)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (12, N'khang', N'123', N'Nguyệt', N'Nguyễn Văn', 0, N'0912874491', N'55647@gmail.com', N'Hóc Môn', 2)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (13, N'admin', N'123', N'Admin', N'Admin', 0, N'0123', N'admin@chuate.com', N'123', 1)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (14, N'phu', N'123', N'Phú', N'Nguyễn', 0, N'0123984757', N'phu@gmail.com', N'123', 2)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (15, N'kiet', N'123', N'Kiệt', N'Cao', 0, N'0912382312', N'kiet@gmail.com', N'123', 2)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (17, N'qwe', N'123', N'Nguyệt', N'Trần', 1, N'123', N'tkk@gmail.com', N'123', 2)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (18, N'admin2', N'123', N'admin2', N'admin2', 1, N'0948272918', N'admin2@chuate.com', N'123', 1)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (19, N'khach', N'123', N'khang', N'khang', 0, N'123123', N'55647@gmail.com', N'123', 2)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (23, N'phu123', N'456', N'Nguyễn Văn', N'Phú', 0, N'0379921203', N'nguyenvanphu103@gmail.com', N'456', 2)
INSERT [dbo].[User] ([id], [username], [password], [fname], [lname], [gender], [phone], [email], [address], [roleid]) VALUES (25, N'khachhang1', N'123', N'Trần', N'Khách', 0, N'0912382312', N'55647@gmail.com', N'123', 2)
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[Orders] ADD  DEFAULT (getdate()) FOR [createAt]
GO
ALTER TABLE [dbo].[Orders] ADD  DEFAULT (NULL) FOR [completedAt]
GO
ALTER TABLE [dbo].[Orders] ADD  DEFAULT (NULL) FOR [quantity]
GO
ALTER TABLE [dbo].[User] ADD  DEFAULT ((0)) FOR [roleid]
GO
ALTER TABLE [dbo].[CartDetail]  WITH CHECK ADD FOREIGN KEY([cartid])
REFERENCES [dbo].[Carts] ([id])
GO
ALTER TABLE [dbo].[CartDetail]  WITH CHECK ADD FOREIGN KEY([productid])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[Carts]  WITH CHECK ADD  CONSTRAINT [FK_Carts_userid] FOREIGN KEY([userid])
REFERENCES [dbo].[User] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Carts] CHECK CONSTRAINT [FK_Carts_userid]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([orderid])
REFERENCES [dbo].[Orders] ([id])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([productid])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_userid] FOREIGN KEY([userid])
REFERENCES [dbo].[User] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_userid]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([brandid])
REFERENCES [dbo].[Brand] ([id])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([categoryid])
REFERENCES [dbo].[Category] ([id])
GO
ALTER TABLE [dbo].[Carts]  WITH CHECK ADD CHECK  (([status]=(1) OR [status]=(2)))
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD CHECK  (([status]=(1) OR [status]=(2) OR [status]=(3) OR [status]=(4)))
GO
/****** Object:  StoredProcedure [dbo].[SP_ChangeInfo]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_ChangeInfo] 
	@id INT, 
	@fname  nvarchar(50), 
	@lname nvarchar(50), 
	@phone nvarchar(50), 
	@email nvarchar(50), 
	@address nvarchar(50)
AS
	UPDATE [User] SET fname=@fname, lname=@lname, phone=@phone, email = @email, address = @address WHERE id = @id
GO
/****** Object:  StoredProcedure [dbo].[SP_ChangePassword]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_ChangePassword] @username nvarchar(50), @old_pass_input nvarchar(50), @new_pass nvarchar(50), @repassword nvarchar(50)
AS
BEGIN
	DECLARE @old_password nvarchar(50) = (SELECT password FROM [User] WHERE username = @username);
	IF(@old_pass_input != '' AND @new_pass != '' AND @repassword != '')
	BEGIN
		IF(@old_pass_input = @old_password AND @new_pass != @old_password AND @new_pass = @repassword)
			UPDATE [User] SET password = @new_pass WHERE username = @username
	END
END
GO
/****** Object:  StoredProcedure [dbo].[SP_DeleteAllCartDetail]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DeleteAllCartDetail]
	@cartid int
AS
BEGIN
	DELETE  FROM [CartDetail] WHERE cartid = @cartid 
END
GO
/****** Object:  StoredProcedure [dbo].[SP_DeleteCart]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DeleteCart]
	@id int,
	@userid int
AS
BEGIN
	DELETE  FROM [Cart] WHERE id = @id AND userid = @userid 
END
GO
/****** Object:  StoredProcedure [dbo].[SP_DeleteCartDetail]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DeleteCartDetail]
	@productid int,
	@cartid int
AS
BEGIN
	DELETE  FROM [CartDetail] WHERE productid = @productid AND cartid = @cartid 
END
GO
/****** Object:  StoredProcedure [dbo].[SP_DeleteCategory]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DeleteCategory] 
	@id int 
AS
BEGIN
	DELETE FROM Category
	WHERE id = @id
END
GO
/****** Object:  StoredProcedure [dbo].[SP_DeleteProduct]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DeleteProduct]
	@id int
AS
BEGIN
	DELETE FROM Product WHERE id=@id
END
GO
/****** Object:  StoredProcedure [dbo].[SP_DeleteUser]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DeleteUser] 
	@id nvarchar(50) 
AS
BEGIN
	DELETE FROM [User]
	WHERE id = @id
END
GO
/****** Object:  StoredProcedure [dbo].[SP_EditCart]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_EditCart]
	@cartid int,
	@quantity  int ,
	@shipping float,
	@total float, 
	@grandtotal float 
	
AS
BEGIN
	UPDATE [Carts] SET quantity = @quantity , shipping = @shipping, total = @total, grandtotal = @grandtotal 
	WHERE id = @cartid
END
GO
/****** Object:  StoredProcedure [dbo].[SP_EditCartDetail]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_EditCartDetail]
	@productid int,
	@cartid int,
	@price float,
	@quantity  int 
	
AS
BEGIN
	UPDATE [CartDetail] SET price = @price , quantity = @quantity
	WHERE productid = @productid AND cartid = @cartid
END
GO
/****** Object:  StoredProcedure [dbo].[SP_EditProduct]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_EditProduct] 
	@id int,
	@productname nvarchar(100), 
	@price float, 
	@saleprice  float,
	@quantity int, 
	@description nvarchar(500), 
	@image nvarchar(MAX), 
	@brandid int, 
	@categoryid int
AS
BEGIN
	UPDATE [Product] SET [name]=@productname, price=@price, 
	saleprice = @saleprice, quantity=@quantity, [description]=@description,
	[image]=@image, brandid=@brandid, categoryid = @categoryid
	WHERE id = @id
END
GO
/****** Object:  StoredProcedure [dbo].[SP_RegisterAdmin]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_RegisterAdmin] 
	@username nvarchar(50), 
	@password nvarchar(50), 
	@fname  nvarchar(50),
	@lname nvarchar(50), 
	@gender int, 
	@phone nvarchar(50), 
	@email nvarchar(50), 
	@address nvarchar(50)
AS
BEGIN
	IF (@username != '' AND @password != '')
		IF (NOT EXISTS (SELECT * FROM [User] WHERE username=@username))
			BEGIN
				INSERT INTO [User] (username, password, fname, lname, gender, phone, email, address, roleid) 
				VALUES (@username, @password, @fname, @lname, @gender, @phone, @email, @address, 1);
			END
END
GO
/****** Object:  StoredProcedure [dbo].[SP_RegisterCart]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_RegisterCart]
	@userid int,
	@quantity  int = 0,
	@shipping float = 0, 
	@total float = 0, 
	@grandtotal float = 0
	
AS
BEGIN
		IF (NOT EXISTS (SELECT * FROM [Carts] WHERE userid = @userid))
			BEGIN
				INSERT INTO [Carts] (quantity, shipping, total, grandtotal, userid) 
				VALUES (@quantity, @shipping, @total, @grandtotal, @userid);
			END
END
GO
/****** Object:  StoredProcedure [dbo].[SP_RegisterCartDetail]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_RegisterCartDetail]
	@productid int,
	@cartid int,
	@price float,
	@quantity  int 
	
AS
BEGIN
	INSERT INTO [CartDetail] (productid, cartid, price, quantity) VALUES (@productid, @cartid, @price, @quantity)
END
GO
/****** Object:  StoredProcedure [dbo].[SP_RegisterCategory]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_RegisterCategory] 
	@name nvarchar(50) 
AS
BEGIN
	INSERT INTO Category([name]) 
	VALUES (@name);	
END
GO
/****** Object:  StoredProcedure [dbo].[SP_RegisterOrderDetail]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_RegisterOrderDetail]
	@productid int,
	@orderid int,
	@price float,
	@quantity  int
AS
BEGIN
	INSERT INTO [OrderDetail] (productid, orderid, price, quantity) 
	VALUES (@productid, @orderid, @price, @quantity);
END
GO
/****** Object:  StoredProcedure [dbo].[SP_RegisterOrders]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_RegisterOrders]
	@quantity  int ,
	@shipping float, 
	@total float, 
	@grandtotal float,
	@userid int
AS
BEGIN
	DECLARE @createAt date = GETDATE();
	DECLARE @status int = 1;
	INSERT INTO [Orders] (createAt, status, quantity, shipping, total, grandtotal, userid) 
	VALUES (@createAt, @status, @quantity, @shipping, @total, @grandtotal, @userid);
END
GO
/****** Object:  StoredProcedure [dbo].[SP_RegisterProduct]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_RegisterProduct] 
	@productname nvarchar(100), 
	@price float, 
	@saleprice  float,
	@quantity int, 
	@description nvarchar(500), 
	@image nvarchar(MAX), 
	@brandid int, 
	@categoryid int
AS
BEGIN
	IF (NOT EXISTS (SELECT * FROM [Product] WHERE [name] = @productname))
		BEGIN
			INSERT INTO [Product] ([name], price, saleprice, quantity, [description], [image], brandid, categoryid) 
			VALUES (@productname, @price, @saleprice, @quantity, @description, @image, @brandid, @categoryid);
		END
END
GO
/****** Object:  StoredProcedure [dbo].[SP_RegisterUser]    Script Date: 18/11/2021 9:36:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_RegisterUser] 
	@username nvarchar(50), 
	@password nvarchar(50), 
	@fname  nvarchar(50),
	@lname nvarchar(50), 
	@gender int, 
	@phone nvarchar(50), 
	@email nvarchar(50), 
	@address nvarchar(50)
AS
BEGIN
	IF (@username != '' AND @password != '')
		IF (NOT EXISTS (SELECT * FROM [User] WHERE username=@username))
			BEGIN
				INSERT INTO [User] (username, password, fname, lname, gender, phone, email, address, roleid) 
				VALUES (@username, @password, @fname, @lname, @gender, @phone, @email, @address, 2);
				IF (EXISTS (SELECT * FROM [User] WHERE username = @username))
					DECLARE @userid int = (SELECT id FROM [User] WHERE username = @username)
					execute [dbo].[SP_RegisterCart] @userid
			END
END
GO
USE [master]
GO
ALTER DATABASE [ShopTheThao2] SET  READ_WRITE 
GO
