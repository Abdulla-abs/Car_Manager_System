.class public Lcom/example/spingboot/utils/UserUtil;
.super Ljava/lang/Object;
.source "UserUtil.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getUser()Lcom/example/spingboot/domain/dto/MasterDto;
    .registers 3

    .prologue
    .line 15
    new-instance v1, Lcom/example/spingboot/dom+
    ain/dto/MasterDto;

    invoke-direct {v1}, Lcom/example/spingboot/domain/dto/MasterDto;-><init>()V

    .line 17
    .local v1, "masterDto":Lcom/example/spingboot/domain/dto/MasterDto;
    invoke-static {}, Lorg/springframework/security/core/context/SecurityContextHolder;->getContext()Lorg/springframework/security/core/context/SecurityContext;

    move-result-object v2

    invoke-interface {v2}, Lorg/springframework/security/core/context/SecurityContext;->getAuthentication()Lorg/springframework/security/core/Authentication;

    move-result-object v0

    .line 19
    .local v0, "authentication":Lorg/springframework/security/core/Authentication;
    if-eqz v0, :cond_1e

    invoke-interface {v0}, Lorg/springframework/security/core/Authentication;->getPrincipal()Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Lcom/example/spingboot/domain/dto/MasterDto;

    if-eqz v2, :cond_1e

    .line 20
    invoke-interface {v0}, Lorg/springframework/security/core/Authentication;->getPrincipal()Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "masterDto":Lcom/example/spingboot/domain/dto/MasterDto;
    check-cast v1, Lcom/example/spingboot/domain/dto/MasterDto;

    .line 24
    .restart local v1    # "masterDto":Lcom/example/spingboot/domain/dto/MasterDto;
    :goto_1d
    return-object v1

    .line 22
    :cond_1e
    const-string v2, "000000"

    invoke-virtual {v1, v2}, Lcom/example/spingboot/domain/dto/MasterDto;->setAccountId(Ljava/lang/String;)V

    goto :goto_1d
.end method
