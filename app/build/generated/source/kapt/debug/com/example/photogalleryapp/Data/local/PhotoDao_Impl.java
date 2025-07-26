package com.example.photogalleryapp.Data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PhotoDao_Impl implements PhotoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PhotoEntity> __insertionAdapterOfPhotoEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public PhotoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPhotoEntity = new EntityInsertionAdapter<PhotoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `photos` (`id`,`url`,`photographer`,`src_portrait`,`src_original`,`src_medium`,`src_large`,`src_tiny`,`src_landscape`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PhotoEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUrl() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUrl());
        }
        if (entity.getPhotographer() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhotographer());
        }
        final PhotoSrcEntity _tmpSrc = entity.getSrc();
        if (_tmpSrc.getPortrait() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmpSrc.getPortrait());
        }
        if (_tmpSrc.getOriginal() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmpSrc.getOriginal());
        }
        if (_tmpSrc.getMedium() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmpSrc.getMedium());
        }
        if (_tmpSrc.getLarge() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmpSrc.getLarge());
        }
        if (_tmpSrc.getTiny() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmpSrc.getTiny());
        }
        if (_tmpSrc.getLandscape() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, _tmpSrc.getLandscape());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM photos";
        return _query;
      }
    };
  }

  @Override
  public Object insertPhotos(final List<PhotoEntity> photos,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPhotoEntity.insert(photos);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllPhotos(final Continuation<? super List<PhotoEntity>> $completion) {
    final String _sql = "SELECT * FROM photos";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PhotoEntity>>() {
      @Override
      @NonNull
      public List<PhotoEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfPhotographer = CursorUtil.getColumnIndexOrThrow(_cursor, "photographer");
          final int _cursorIndexOfPortrait = CursorUtil.getColumnIndexOrThrow(_cursor, "src_portrait");
          final int _cursorIndexOfOriginal = CursorUtil.getColumnIndexOrThrow(_cursor, "src_original");
          final int _cursorIndexOfMedium = CursorUtil.getColumnIndexOrThrow(_cursor, "src_medium");
          final int _cursorIndexOfLarge = CursorUtil.getColumnIndexOrThrow(_cursor, "src_large");
          final int _cursorIndexOfTiny = CursorUtil.getColumnIndexOrThrow(_cursor, "src_tiny");
          final int _cursorIndexOfLandscape = CursorUtil.getColumnIndexOrThrow(_cursor, "src_landscape");
          final List<PhotoEntity> _result = new ArrayList<PhotoEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PhotoEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final String _tmpPhotographer;
            if (_cursor.isNull(_cursorIndexOfPhotographer)) {
              _tmpPhotographer = null;
            } else {
              _tmpPhotographer = _cursor.getString(_cursorIndexOfPhotographer);
            }
            final PhotoSrcEntity _tmpSrc;
            final String _tmpPortrait;
            if (_cursor.isNull(_cursorIndexOfPortrait)) {
              _tmpPortrait = null;
            } else {
              _tmpPortrait = _cursor.getString(_cursorIndexOfPortrait);
            }
            final String _tmpOriginal;
            if (_cursor.isNull(_cursorIndexOfOriginal)) {
              _tmpOriginal = null;
            } else {
              _tmpOriginal = _cursor.getString(_cursorIndexOfOriginal);
            }
            final String _tmpMedium;
            if (_cursor.isNull(_cursorIndexOfMedium)) {
              _tmpMedium = null;
            } else {
              _tmpMedium = _cursor.getString(_cursorIndexOfMedium);
            }
            final String _tmpLarge;
            if (_cursor.isNull(_cursorIndexOfLarge)) {
              _tmpLarge = null;
            } else {
              _tmpLarge = _cursor.getString(_cursorIndexOfLarge);
            }
            final String _tmpTiny;
            if (_cursor.isNull(_cursorIndexOfTiny)) {
              _tmpTiny = null;
            } else {
              _tmpTiny = _cursor.getString(_cursorIndexOfTiny);
            }
            final String _tmpLandscape;
            if (_cursor.isNull(_cursorIndexOfLandscape)) {
              _tmpLandscape = null;
            } else {
              _tmpLandscape = _cursor.getString(_cursorIndexOfLandscape);
            }
            _tmpSrc = new PhotoSrcEntity(_tmpPortrait,_tmpOriginal,_tmpMedium,_tmpLarge,_tmpTiny,_tmpLandscape);
            _item = new PhotoEntity(_tmpId,_tmpUrl,_tmpPhotographer,_tmpSrc);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
