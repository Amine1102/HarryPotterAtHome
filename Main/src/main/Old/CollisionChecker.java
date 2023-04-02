/*
package main.Old;

import main.Old.entity.Entity;
import main.Old.tile.GamePanel;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity main.Old.entity){
        int entityLeftWorldX = main.Old.entity.worldX + main.Old.entity.solidArea.x;
        int entityRightWorldX = main.Old.entity.worldX + main.Old.entity.solidArea.x  + main.Old.entity.solidArea.width;
        int entityTopWorldY = main.Old.entity.worldY + main.Old.entity.solidArea.y ;
        int entityBottomWorldY = main.Old.entity.worldY + main.Old.entity.solidArea.y + main.Old.entity.solidArea.height;


        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (main.Old.entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - main.Old.entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision==true){
                    main.Old.entity.collisionOn = true;
                }
                break;
            case "down" :
                entityBottomRow = (entityBottomWorldY + main.Old.entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision==true){
                    main.Old.entity.collisionOn = true;
                }
                break;
            case "left" :
                entityLeftCol = (entityLeftWorldX - main.Old.entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision==true){
                    main.Old.entity.collisionOn = true;
                }
                break;
            case "right" :
                entityRightCol = (entityTopWorldY + main.Old.entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision==true){
                    main.Old.entity.collisionOn = true;
                }
                break;
        }

    }
    public int checkObject(Entity main.Old.entity, boolean player){
        int index = 999;

        for(int i =0; i<gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                // GEt main.Old.entity's solid area position
                main.Old.entity.solidArea.x = main.Old.entity.worldX + main.Old.entity.solidArea.x;
                main.Old.entity.solidArea.y = main.Old.entity.worldY + main.Old.entity.solidArea.y;
                // Get objects posiion
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch (main.Old.entity.direction) {
                    case "up":
                        main.Old.entity.solidArea.y -= main.Old.entity.speed;
                        if (main.Old.entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true){
                                main.Old.entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        main.Old.entity.solidArea.y += main.Old.entity.speed;
                        if (main.Old.entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true){
                                main.Old.entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        main.Old.entity.solidArea.x -= main.Old.entity.speed;
                        if (main.Old.entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true){
                                main.Old.entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        main.Old.entity.solidArea.x += main.Old.entity.speed;
                        if (main.Old.entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true){
                                main.Old.entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        break;
                        }
                    }
                main.Old.entity.solidArea.x = main.Old.entity.solidAreaDefaultX;
                main.Old.entity.solidArea.y = main.Old.entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
//
    }
}



 */