USE [yugioh]
GO

/****** Object:  Table [dbo].[card]    Script Date: 15/10/2022 03:53:30 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[card](
	[id] [int] NOT NULL,
	[name] [varchar](100) NOT NULL,
	[type] [varchar](50) NOT NULL,
	[desc] [text] NOT NULL,
	[atk] [int] NULL,
	[def] [int] NULL,
	[level] [int] NULL,
	[race] [varchar](50) NOT NULL,
	[attribute] [varchar](50) NULL,
	[image] [varchar](max) NOT NULL,
	[linkval] [int] NULL,
	[linkmarkers] [varchar](max) NULL,
	[scale] [int] NULL,
	[isStaple] [bit] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

