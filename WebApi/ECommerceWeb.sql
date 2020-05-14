USE [E_COMMERCE_WEB]
GO
/****** Object:  Table [dbo].[Cards]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cards](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Image] [nvarchar](500) NULL,
	[ProId] [int] NOT NULL,
 CONSTRAINT [PK_Cards] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CartItems]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CartItems](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Quantity] [int] NOT NULL,
	[ProId] [int] NOT NULL,
	[CartId] [int] NOT NULL,
 CONSTRAINT [PK__CartItem__3214EC0704141BF6] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Carts]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NOT NULL,
 CONSTRAINT [PK__Carts__3214EC0718967049] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Categories]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CateId] [int] IDENTITY(1,1) NOT NULL,
	[CateName] [nvarchar](255) NOT NULL,
	[CateImage] [nvarchar](500) NULL,
	[Display] [bit] NOT NULL,
 CONSTRAINT [PK__Categori__27638D142D0C84FA] PRIMARY KEY CLUSTERED 
(
	[CateId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderItems]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderItems](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Quantity] [int] NOT NULL,
	[UnitPrice] [float] NOT NULL,
	[ProId] [int] NOT NULL,
	[OrderId] [int] NOT NULL,
 CONSTRAINT [PK_OrderItems] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Orders]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NOT NULL,
	[BuyDate] [date] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Phone] [nchar](10) NULL,
	[Email] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
	[Note] [nvarchar](200) NULL,
	[StatusId] [int] NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Products]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NOT NULL,
	[Stock] [int] NOT NULL,
	[Price] [float] NOT NULL,
	[Discount] [float] NOT NULL,
	[CateId] [int] NOT NULL,
	[Description] [nvarchar](2000) NULL,
	[Information] [nvarchar](2000) NULL,
	[Image] [nvarchar](500) NULL,
	[Display] [bit] NOT NULL,
 CONSTRAINT [PK__Products__3214EC078D14CE25] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Roles]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Statuses]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Statuses](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[StatusName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Statuses] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Phone] [nchar](10) NOT NULL,
	[Address] [nvarchar](150) NOT NULL,
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](36) NOT NULL,
	[Avatar] [nvarchar](500) NULL,
	[RoleId] [int] NOT NULL,
	[Lock] [bit] NOT NULL,
 CONSTRAINT [PK__Users__3214EC072ADE063C] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[CartItems] ON 

INSERT [dbo].[CartItems] ([Id], [Quantity], [ProId], [CartId]) VALUES (11, 1, 1, 2)
INSERT [dbo].[CartItems] ([Id], [Quantity], [ProId], [CartId]) VALUES (12, 1, 4, 3)
SET IDENTITY_INSERT [dbo].[CartItems] OFF
SET IDENTITY_INSERT [dbo].[Carts] ON 

INSERT [dbo].[Carts] ([Id], [UserId]) VALUES (2, 2)
INSERT [dbo].[Carts] ([Id], [UserId]) VALUES (3, 5)
INSERT [dbo].[Carts] ([Id], [UserId]) VALUES (4, 6)
SET IDENTITY_INSERT [dbo].[Carts] OFF
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([CateId], [CateName], [CateImage], [Display]) VALUES (1, N'Điện thoại', NULL, 1)
SET IDENTITY_INSERT [dbo].[Categories] OFF
SET IDENTITY_INSERT [dbo].[OrderItems] ON 

INSERT [dbo].[OrderItems] ([Id], [Quantity], [UnitPrice], [ProId], [OrderId]) VALUES (1, 1, 29000000, 1, 1)
INSERT [dbo].[OrderItems] ([Id], [Quantity], [UnitPrice], [ProId], [OrderId]) VALUES (2, 3, 15000000, 4, 1)
INSERT [dbo].[OrderItems] ([Id], [Quantity], [UnitPrice], [ProId], [OrderId]) VALUES (3, 2, 5000000, 5, 1)
INSERT [dbo].[OrderItems] ([Id], [Quantity], [UnitPrice], [ProId], [OrderId]) VALUES (4, 1, 22000000, 2, 2)
INSERT [dbo].[OrderItems] ([Id], [Quantity], [UnitPrice], [ProId], [OrderId]) VALUES (5, 3, 5000000, 5, 2)
INSERT [dbo].[OrderItems] ([Id], [Quantity], [UnitPrice], [ProId], [OrderId]) VALUES (6, 1, 20900000, 2, 3)
INSERT [dbo].[OrderItems] ([Id], [Quantity], [UnitPrice], [ProId], [OrderId]) VALUES (7, 2, 13500000, 4, 3)
SET IDENTITY_INSERT [dbo].[OrderItems] OFF
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([Id], [UserId], [BuyDate], [Name], [Phone], [Email], [Address], [Note], [StatusId]) VALUES (1, 5, CAST(N'2020-05-13' AS Date), N'Thu', N'0326779770', N'ltt123@gmail.com', N'48, MT', N'none', 1)
INSERT [dbo].[Orders] ([Id], [UserId], [BuyDate], [Name], [Phone], [Email], [Address], [Note], [StatusId]) VALUES (2, 2, CAST(N'2020-05-13' AS Date), N'Thuỷ', N'0326779770', N'ptt123@gmail.com', N'50, MT', N'none', 1)
INSERT [dbo].[Orders] ([Id], [UserId], [BuyDate], [Name], [Phone], [Email], [Address], [Note], [StatusId]) VALUES (3, 2, CAST(N'2020-05-13' AS Date), N'Thuỷ', N'0326779770', N'ptt123@gmail.com', N'50, MT', N'none', 1)
SET IDENTITY_INSERT [dbo].[Orders] OFF
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([Id], [Name], [Stock], [Price], [Discount], [CateId], [Description], [Information], [Image], [Display]) VALUES (1, N'iPhone 11 Pro Max', 99, 29000000, 0, 1, NULL, NULL, NULL, 1)
INSERT [dbo].[Products] ([Id], [Name], [Stock], [Price], [Discount], [CateId], [Description], [Information], [Image], [Display]) VALUES (2, N'Samsung S10', 88, 22000000, 0.05, 1, NULL, NULL, NULL, 1)
INSERT [dbo].[Products] ([Id], [Name], [Stock], [Price], [Discount], [CateId], [Description], [Information], [Image], [Display]) VALUES (4, N'Oppo Reno', 90, 15000000, 0.1, 1, NULL, NULL, NULL, 1)
INSERT [dbo].[Products] ([Id], [Name], [Stock], [Price], [Discount], [CateId], [Description], [Information], [Image], [Display]) VALUES (5, N'Realme C3', 75, 5000000, 0, 1, NULL, NULL, NULL, 1)
SET IDENTITY_INSERT [dbo].[Products] OFF
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([Id], [RoleName]) VALUES (1, N'User')
INSERT [dbo].[Roles] ([Id], [RoleName]) VALUES (2, N'Admin')
SET IDENTITY_INSERT [dbo].[Roles] OFF
SET IDENTITY_INSERT [dbo].[Statuses] ON 

INSERT [dbo].[Statuses] ([Id], [StatusName]) VALUES (1, N'Chờ xác nhận')
INSERT [dbo].[Statuses] ([Id], [StatusName]) VALUES (2, N'Đang giao hàng')
INSERT [dbo].[Statuses] ([Id], [StatusName]) VALUES (3, N'Đã giao hàng')
INSERT [dbo].[Statuses] ([Id], [StatusName]) VALUES (4, N'Đã huỷ')
SET IDENTITY_INSERT [dbo].[Statuses] OFF
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([Id], [Name], [Email], [Phone], [Address], [Username], [Password], [Avatar], [RoleId], [Lock]) VALUES (2, N'Phạm Thị Thuỷ', N'ptt@gmail.com', N'0347783547', N'97, Man Thiện', N'ptt', N'123', NULL, 1, 0)
INSERT [dbo].[Users] ([Id], [Name], [Email], [Phone], [Address], [Username], [Password], [Avatar], [RoleId], [Lock]) VALUES (5, N'Lê Thị Thu', N'ltt@gmail.com', N'0356799685', N'99, Man thiện', N'ltt', N'1234', NULL, 1, 0)
INSERT [dbo].[Users] ([Id], [Name], [Email], [Phone], [Address], [Username], [Password], [Avatar], [RoleId], [Lock]) VALUES (6, N'Lê Hồng Quân', N'lhq@gmail.com', N'0326779770', N'48, MT', N'lhq', N'123', NULL, 1, 0)
SET IDENTITY_INSERT [dbo].[Users] OFF
/****** Object:  Index [Unique_UserId]    Script Date: 5/14/2020 1:08:54 PM ******/
ALTER TABLE [dbo].[Carts] ADD  CONSTRAINT [Unique_UserId] UNIQUE NONCLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Users__536C85E4A2F8190E]    Script Date: 5/14/2020 1:08:54 PM ******/
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [UQ__Users__536C85E4A2F8190E] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cards]  WITH CHECK ADD  CONSTRAINT [FK_Cards_Products] FOREIGN KEY([ProId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[Cards] CHECK CONSTRAINT [FK_Cards_Products]
GO
ALTER TABLE [dbo].[CartItems]  WITH CHECK ADD  CONSTRAINT [FK__CartItems__CartI__1BFD2C07] FOREIGN KEY([CartId])
REFERENCES [dbo].[Carts] ([Id])
GO
ALTER TABLE [dbo].[CartItems] CHECK CONSTRAINT [FK__CartItems__CartI__1BFD2C07]
GO
ALTER TABLE [dbo].[CartItems]  WITH CHECK ADD  CONSTRAINT [FK__CartItems__ProId__1B0907CE] FOREIGN KEY([ProId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[CartItems] CHECK CONSTRAINT [FK__CartItems__ProId__1B0907CE]
GO
ALTER TABLE [dbo].[Carts]  WITH CHECK ADD  CONSTRAINT [FK_Carts_Users] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([Id])
GO
ALTER TABLE [dbo].[Carts] CHECK CONSTRAINT [FK_Carts_Users]
GO
ALTER TABLE [dbo].[OrderItems]  WITH CHECK ADD  CONSTRAINT [FK_OrderItems_Orders] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([Id])
GO
ALTER TABLE [dbo].[OrderItems] CHECK CONSTRAINT [FK_OrderItems_Orders]
GO
ALTER TABLE [dbo].[OrderItems]  WITH CHECK ADD  CONSTRAINT [FK_OrderItems_Products] FOREIGN KEY([ProId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[OrderItems] CHECK CONSTRAINT [FK_OrderItems_Products]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Statuses] FOREIGN KEY([StatusId])
REFERENCES [dbo].[Statuses] ([Id])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Statuses]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Users] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([Id])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Users]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK__Products__CateId__15502E78] FOREIGN KEY([CateId])
REFERENCES [dbo].[Categories] ([CateId])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK__Products__CateId__15502E78]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Roles] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Roles] ([Id])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Roles]
GO
/****** Object:  StoredProcedure [dbo].[CheckOut]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CheckOut]
	@userId INT,
	@name NVARCHAR(50),
	@phone NCHAR(10),
	@email NVARCHAR(50),
	@address NVARCHAR(50),
	@note NVARCHAR(200)	
AS
BEGIN
	DECLARE @cartId INT = 0

	SET @cartId = (SELECT Id FROM dbo.Carts WHERE UserId = @userId)	 
			
	SET XACT_ABORT ON
	BEGIN TRY
		BEGIN TRANSACTION
		
		--xử lý
		INSERT dbo.Orders
	        ( UserId ,
	          BuyDate ,
	          Name ,
	          Phone ,
	          Email ,
	          Address ,
	          Note ,
	          StatusId
	        )
		VALUES  ( @userId , -- UserId - int
				  GETDATE() , -- BuyDate - date
				  @name , -- Name - nvarchar(50)
				  @phone , -- Phone - nchar(10)
				  @email , -- Email - nvarchar(50)
				  @address , -- Address - nvarchar(50)
				  @note , -- Note - nvarchar(200)
				  1  -- StatusId - int
				)

		INSERT INTO dbo.OrderItems (Quantity, UnitPrice, ProId, OrderId)
		SELECT ci.Quantity, pro.Price - (pro.Price * pro.Discount), ci.ProId, (SELECT TOP(1)Id FROM dbo.Orders ORDER BY Id DESC)
		FROM dbo.CartItems ci INNER JOIN dbo.Products pro ON pro.Id = ci.ProId
		WHERE ci.CartId = @cartId	

		UPDATE dbo.Products SET Stock = Stock - oi.Quantity 
		FROM dbo.Products pro INNER JOIN dbo.OrderItems oi ON oi.ProId = pro.Id
		WHERE oi.OrderId = (SELECT TOP(1)Id FROM dbo.Orders ORDER BY Id DESC)	

		DELETE dbo.CartItems
		WHERE CartId = @cartId
		---------------------------
		IF(@@TRANCOUNT > 0)
		BEGIN
			PRINT 'Commit Success'
			COMMIT TRANSACTION
			SELECT 1 AS result, N'thành công' AS message	--Thành công
		END
	END TRY
	BEGIN CATCH
		IF(@@TRANCOUNT > 0)
		BEGIN
			ROLLBACK TRANSACTION
			PRINT 'Commit Failure'
			SELECT 0 AS result, N'thất bại' AS message	--Thất bại
		END
	END CATCH

END

GO
/****** Object:  StoredProcedure [dbo].[GetAllCards]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[GetAllCards]	
AS
BEGIN
	SELECT *
	FROM dbo.Cards
END

GO
/****** Object:  StoredProcedure [dbo].[GetAllCategories]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[GetAllCategories]	
AS
BEGIN
	SELECT *
	FROM dbo.Categories
END

GO
/****** Object:  StoredProcedure [dbo].[GetAllOrdersOfUser]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[GetAllOrdersOfUser]
	@userId INT	
AS
BEGIN
	SELECT *
	FROM dbo.Orders
	WHERE UserId = @userId
END

GO
/****** Object:  StoredProcedure [dbo].[GetAllProducts]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[GetAllProducts]
AS
    BEGIN
        SELECT  dbo.Products.Id ,
                dbo.Products.Name,
                dbo.Categories.CateName,
                dbo.Products.Stock,
                dbo.Products.Price,
                dbo.Products.Discount,
                dbo.Products.Description,
                dbo.Products.Information,
                dbo.Products.Image
        FROM    dbo.Categories
                INNER JOIN dbo.Products ON dbo.Categories.CateId = dbo.Products.CateId
    END

GO
/****** Object:  StoredProcedure [dbo].[GetAllProductsOfCart]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[GetAllProductsOfCart]
	@userId INT	
AS
BEGIN
	SELECT pro.*
	FROM dbo.Products pro INNER JOIN dbo.CartItems ci ON ci.ProId = pro.Id
	WHERE ci.CartId = (SELECT Id FROM dbo.Carts WHERE UserId = @userId)  
END

GO
/****** Object:  StoredProcedure [dbo].[GetAllProductsOfCategory]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[GetAllProductsOfCategory]
	@cateId INT		
AS
BEGIN
	SELECT *
	FROM dbo.Products
	WHERE CateId = @cateId
END

GO
/****** Object:  StoredProcedure [dbo].[GetAllSaleProducts]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[GetAllSaleProducts]		
AS
BEGIN
	SELECT *
	FROM dbo.Products
	WHERE Discount > 0
END

GO
/****** Object:  StoredProcedure [dbo].[GetCartCount]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[GetCartCount]
	@userId INT	
AS
BEGIN
	SELECT COUNT(ProId)
	FROM dbo.CartItems INNER JOIN dbo.Carts
	ON Carts.Id = CartItems.CartId
	WHERE UserId = @userId	
END

GO
/****** Object:  StoredProcedure [dbo].[Login]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Login]
	@userName VARCHAR(50),
	@password VARCHAR(36)
AS
BEGIN
	IF NOT EXISTS (SELECT * FROM dbo.Users WHERE Username = @userName)
		SELECT -1 AS result, N'sai username' AS message --sai userName
	ELSE IF EXISTS (SELECT * FROM dbo.Users WHERE Username = @userName AND Password != @password)
		SELECT -2 AS result, N'đúng userName, sai password' AS message --đúng userName, sai password
	ELSE
		SELECT 1 AS result, N'đăng nhập thành công' AS message --đăng nhập thành công	
END

GO
/****** Object:  StoredProcedure [dbo].[MinusCartItem]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[MinusCartItem]
	@userId INT,
	@productId INT	
AS
BEGIN
	DECLARE @cartId INT = 0 
	DECLARE @cartItemId INT = 0 	 
	DECLARE @quantity INT = 0
	
	SET @cartId = (SELECT Id FROM dbo.Carts WHERE UserId = @userId)
	SET @cartItemId = (SELECT Id FROM dbo.CartItems	WHERE CartId = @cartId AND ProId = @productId)
	SET @quantity = (SELECT Quantity FROM dbo.CartItems WHERE CartId = @cartId AND ProId = @productId)
									
	IF (@cartItemId > 0)
		BEGIN
			IF (@quantity > 1)
				BEGIN
					UPDATE dbo.CartItems 
					SET Quantity = Quantity - 1
					WHERE Id = @cartItemId
				END
			ELSE
				BEGIN
					DELETE dbo.CartItems
					WHERE Id = @cartItemId
				END
			SELECT 1 AS result, N'thành công' AS message --thành công
		END
	ELSE
		SELECT 0 AS result, N'thất bại' AS message --thất bại	
END

GO
/****** Object:  StoredProcedure [dbo].[PlusCartItem]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[PlusCartItem]
	@userId INT,
	@productId INT,
	@quantity INT	
AS
BEGIN
	DECLARE @cartId INT = 0
	DECLARE @cartItemId INT = 0
	DECLARE @stock INT = 0

	SET @cartId = (SELECT Id FROM dbo.Carts WHERE UserId = @userId)
	SET @cartItemId = (SELECT Id FROM dbo.CartItems WHERE CartId = @cartId AND ProId = @productId)	 
	SET @stock = (SELECT pro.Stock FROM dbo.Products pro INNER JOIN dbo.CartItems ci ON ci.ProId = pro.Id WHERE ci.Id = @cartItemId)
		
	IF (@cartItemId > 0)
		BEGIN
			IF(@quantity <= @stock)
				BEGIN
					UPDATE dbo.CartItems 
					SET Quantity = Quantity + @quantity 
					WHERE Id = @cartItemId

					SELECT 1 AS result, N'thành công' AS message --thành công
				END
			ELSE
				SELECT -1 AS result, N'số lượng tồn không đủ' AS message --số lượng tồn không đủ 				
		END
	ELSE
		BEGIN
			INSERT dbo.CartItems
			        ( Quantity, ProId, CartId )
			VALUES  ( @quantity, -- Quantity - int
			          @productId, -- ProId - int
			          @cartId  -- CartId - int
			          )
			SELECT 1 AS result, N'thành công' AS message --thành công
		END      
END

GO
/****** Object:  StoredProcedure [dbo].[SignUp]    Script Date: 5/14/2020 1:08:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SignUp]	
	@userName VARCHAR(50),
	@password VARCHAR(36),
	@name NVARCHAR(50),
	@email NVARCHAR(50),
	@phone NCHAR(10),
	@address NVARCHAR(150)
AS
BEGIN
	IF EXISTS (SELECT * FROM dbo.Users WHERE Username = @userName)
		SELECT -1 AS result, N'trùng userName' AS message --trùng userName
	ELSE IF EXISTS (SELECT * FROM dbo.Users WHERE Email = @email)
		SELECT -2 AS result, N'trùng email' AS message --trùng email
	ELSE IF EXISTS (SELECT * FROM dbo.Users WHERE Phone = @phone)
		SELECT -3 AS result, N'trùng số điện thoại' AS message --trùng phone
	ELSE
		BEGIN	
			INSERT dbo.Users
			        ( Name ,
			          Email ,
			          Phone ,
			          Address ,
			          Username ,
			          Password ,
			          Avatar ,
			          RoleId ,
			          Lock
			        )
			VALUES  ( @name , -- Name - nvarchar(50)
			          @email , -- Email - nvarchar(50)
			          @phone , -- Phone - nchar(10)
			          @address , -- Address - nvarchar(150)
			          @userName , -- Username - varchar(50)
			          @password , -- Password - varchar(36)
			          NULL , -- Avatar - nvarchar(500)
			          1 , -- RoleId - int
			          0  -- Lock - bit
			        )
			
			INSERT dbo.Carts
			        ( UserId )
			VALUES  ( (SELECT TOP(1)Id FROM dbo.Users ORDER BY Id DESC)   -- UserId - int
			          )

			SELECT 1 AS result, N'đăng ký thành công' AS message --đăng ký thành công
		END
		
END

GO
