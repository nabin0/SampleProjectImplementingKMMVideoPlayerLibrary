#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class SVPVideoItem, SVPClosedCaptionForTrackSelector, SVPAudioTrack, SVPVideoQuality, AVPlayer, SVPVideoPlayerController, SVPClosedCaption, SVPKotlinByteIterator, SVPKotlinByteArray, NSData, UIViewController, SVPReadableTime, SVPKotlinThrowable, SVPKotlinArray<T>, SVPKotlinException, SVPKotlinRuntimeException, SVPKotlinIllegalStateException;

@protocol SVPPlatform, SVPKotlinx_coroutines_coreMutableStateFlow, SVPUiModifier, SVPKotlinx_coroutines_coreFlowCollector, SVPKotlinx_coroutines_coreFlow, SVPKotlinx_coroutines_coreSharedFlow, SVPKotlinx_coroutines_coreStateFlow, SVPKotlinx_coroutines_coreMutableSharedFlow, SVPKotlinIterator, SVPUiModifierElement;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface SVPBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface SVPBase (SVPBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface SVPMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface SVPMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorSVPKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface SVPNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface SVPByte : SVPNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface SVPUByte : SVPNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface SVPShort : SVPNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface SVPUShort : SVPNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface SVPInt : SVPNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface SVPUInt : SVPNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface SVPLong : SVPNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface SVPULong : SVPNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface SVPFloat : SVPNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface SVPDouble : SVPNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface SVPBoolean : SVPNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Greeting")))
@interface SVPGreeting : SVPBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)greet __attribute__((swift_name("greet()")));
@end

__attribute__((swift_name("Platform")))
@protocol SVPPlatform
@required
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IOSPlatform")))
@interface SVPIOSPlatform : SVPBase <SVPPlatform>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CounterData")))
@interface SVPCounterData : SVPBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("DrmPlayerController")))
@interface SVPDrmPlayerController : NSObject
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("PlayerDTest")))
@interface SVPPlayerDTest : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("VideoPlayerController")))
@interface SVPVideoPlayerController : SVPBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)addPlayListListOfVideos:(NSArray<SVPVideoItem *> *)listOfVideos __attribute__((swift_name("addPlayList(listOfVideos:)")));
- (int64_t)currentPosition __attribute__((swift_name("currentPosition()")));
- (SVPClosedCaptionForTrackSelector *)getCurrentCC __attribute__((swift_name("getCurrentCC()")));
- (float)getCurrentPlaybackSpeed __attribute__((swift_name("getCurrentPlaybackSpeed()")));
- (SVPAudioTrack * _Nullable)getCurrentSelectedAudioTrack __attribute__((swift_name("getCurrentSelectedAudioTrack()")));
- (SVPVideoQuality *)getCurrentVideoStreamingQuality __attribute__((swift_name("getCurrentVideoStreamingQuality()")));
- (void)observeTimeControlStatusPlayer:(AVPlayer *)player onChange:(void (^)(SVPInt *))onChange __attribute__((swift_name("observeTimeControlStatus(player:onChange:)")));
- (void)pause __attribute__((swift_name("pause()")));
- (void)play __attribute__((swift_name("play()")));
- (void)playNextFromPlaylist __attribute__((swift_name("playNextFromPlaylist()")));
- (void)playPreviousFromPlaylist __attribute__((swift_name("playPreviousFromPlaylist()")));
- (void)playWhenReadyBoolean:(BOOL)boolean __attribute__((swift_name("playWhenReady(boolean:)")));
- (void)prepare __attribute__((swift_name("prepare()")));
- (void)releasePlayer __attribute__((swift_name("releasePlayer()")));
- (void)seekToMillis:(int64_t)millis __attribute__((swift_name("seekTo(millis:)")));
- (void)setCCEnabledEnabled:(BOOL)enabled __attribute__((swift_name("setCCEnabled(enabled:)")));
- (void)setMediaItemVideoItem:(SVPVideoItem *)videoItem __attribute__((swift_name("setMediaItem(videoItem:)")));
- (void)setPlayListListOfVideos:(NSArray<SVPVideoItem *> *)listOfVideos __attribute__((swift_name("setPlayList(listOfVideos:)")));
- (void)setPlaybackSpeedSelectedPlaybackSpeed:(float)selectedPlaybackSpeed __attribute__((swift_name("setPlaybackSpeed(selectedPlaybackSpeed:)")));
- (void)setSpecificAudioTrackAudioTrack:(SVPAudioTrack *)audioTrack __attribute__((swift_name("setSpecificAudioTrack(audioTrack:)")));
- (void)setSpecificCCCc:(SVPClosedCaptionForTrackSelector *)cc __attribute__((swift_name("setSpecificCC(cc:)")));
- (void)setSpecificVideoQualityVideoQuality:(SVPVideoQuality *)videoQuality __attribute__((swift_name("setSpecificVideoQuality(videoQuality:)")));
- (void)setVolumeLevelVolumeLevel:(float)volumeLevel __attribute__((swift_name("setVolumeLevel(volumeLevel:)")));
- (void)stop __attribute__((swift_name("stop()")));
@property (readonly) id<SVPKotlinx_coroutines_coreMutableStateFlow> isBuffering __attribute__((swift_name("isBuffering")));
@property (readonly) id<SVPKotlinx_coroutines_coreMutableStateFlow> isPlaying __attribute__((swift_name("isPlaying")));
@property (readonly) id<SVPKotlinx_coroutines_coreMutableStateFlow> listOfAudioFormats __attribute__((swift_name("listOfAudioFormats")));
@property (readonly) id<SVPKotlinx_coroutines_coreMutableStateFlow> listOfCC __attribute__((swift_name("listOfCC")));
@property (readonly) id<SVPKotlinx_coroutines_coreMutableStateFlow> listOfVideoResolutions __attribute__((swift_name("listOfVideoResolutions")));
@property (readonly) id<SVPKotlinx_coroutines_coreMutableStateFlow> mediaDuration __attribute__((swift_name("mediaDuration")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("VideoPlayerControllerFactory")))
@interface SVPVideoPlayerControllerFactory : SVPBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (SVPVideoPlayerController *)createVideoPlayer __attribute__((swift_name("createVideoPlayer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AudioTrack")))
@interface SVPAudioTrack : SVPBase
- (instancetype)initWithIndex:(int32_t)index language:(NSString *)language name:(NSString * _Nullable)name isStereo:(BOOL)isStereo isSurround:(BOOL)isSurround audioTrackGroupIndex:(int32_t)audioTrackGroupIndex __attribute__((swift_name("init(index:language:name:isStereo:isSurround:audioTrackGroupIndex:)"))) __attribute__((objc_designated_initializer));
- (SVPAudioTrack *)doCopyIndex:(int32_t)index language:(NSString *)language name:(NSString * _Nullable)name isStereo:(BOOL)isStereo isSurround:(BOOL)isSurround audioTrackGroupIndex:(int32_t)audioTrackGroupIndex __attribute__((swift_name("doCopy(index:language:name:isStereo:isSurround:audioTrackGroupIndex:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t audioTrackGroupIndex __attribute__((swift_name("audioTrackGroupIndex")));
@property (readonly) int32_t index __attribute__((swift_name("index")));
@property (readonly) BOOL isStereo __attribute__((swift_name("isStereo")));
@property (readonly) BOOL isSurround __attribute__((swift_name("isSurround")));
@property (readonly) NSString *language __attribute__((swift_name("language")));
@property (readonly) NSString * _Nullable name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClosedCaption")))
@interface SVPClosedCaption : SVPBase
- (instancetype)initWithSubtitleLink:(NSString *)subtitleLink language:(NSString *)language __attribute__((swift_name("init(subtitleLink:language:)"))) __attribute__((objc_designated_initializer));
- (SVPClosedCaption *)doCopySubtitleLink:(NSString *)subtitleLink language:(NSString *)language __attribute__((swift_name("doCopy(subtitleLink:language:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *language __attribute__((swift_name("language")));
@property (readonly) NSString *subtitleLink __attribute__((swift_name("subtitleLink")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ClosedCaptionForTrackSelector")))
@interface SVPClosedCaptionForTrackSelector : SVPBase
- (instancetype)initWithIndex:(int32_t)index language:(NSString *)language name:(NSString * _Nullable)name __attribute__((swift_name("init(index:language:name:)"))) __attribute__((objc_designated_initializer));
- (SVPClosedCaptionForTrackSelector *)doCopyIndex:(int32_t)index language:(NSString *)language name:(NSString * _Nullable)name __attribute__((swift_name("doCopy(index:language:name:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t index __attribute__((swift_name("index")));
@property (readonly) NSString *language __attribute__((swift_name("language")));
@property (readonly) NSString * _Nullable name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("VideoItem")))
@interface SVPVideoItem : SVPBase
- (instancetype)initWithVideoUrl:(NSString *)videoUrl title:(NSString * _Nullable)title videoDescription:(NSString * _Nullable)videoDescription licenseUrl:(NSString * _Nullable)licenseUrl listOfClosedCaptions:(NSArray<SVPClosedCaption *> * _Nullable)listOfClosedCaptions isDrmEnabled:(SVPBoolean * _Nullable)isDrmEnabled licenseToken:(NSString * _Nullable)licenseToken certificateUrl:(NSString * _Nullable)certificateUrl __attribute__((swift_name("init(videoUrl:title:videoDescription:licenseUrl:listOfClosedCaptions:isDrmEnabled:licenseToken:certificateUrl:)"))) __attribute__((objc_designated_initializer));
- (SVPVideoItem *)doCopyVideoUrl:(NSString *)videoUrl title:(NSString * _Nullable)title videoDescription:(NSString * _Nullable)videoDescription licenseUrl:(NSString * _Nullable)licenseUrl listOfClosedCaptions:(NSArray<SVPClosedCaption *> * _Nullable)listOfClosedCaptions isDrmEnabled:(SVPBoolean * _Nullable)isDrmEnabled licenseToken:(NSString * _Nullable)licenseToken certificateUrl:(NSString * _Nullable)certificateUrl __attribute__((swift_name("doCopy(videoUrl:title:videoDescription:licenseUrl:listOfClosedCaptions:isDrmEnabled:licenseToken:certificateUrl:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable certificateUrl __attribute__((swift_name("certificateUrl")));
@property (readonly) SVPBoolean * _Nullable isDrmEnabled __attribute__((swift_name("isDrmEnabled")));
@property (readonly) NSString * _Nullable licenseToken __attribute__((swift_name("licenseToken")));
@property (readonly) NSString * _Nullable licenseUrl __attribute__((swift_name("licenseUrl")));
@property (readonly) NSArray<SVPClosedCaption *> * _Nullable listOfClosedCaptions __attribute__((swift_name("listOfClosedCaptions")));
@property (readonly) NSString * _Nullable title __attribute__((swift_name("title")));
@property (readonly) NSString * _Nullable videoDescription __attribute__((swift_name("videoDescription")));
@property (readonly) NSString *videoUrl __attribute__((swift_name("videoUrl")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("VideoQuality")))
@interface SVPVideoQuality : SVPBase
- (instancetype)initWithIndex:(int32_t)index value:(NSString *)value resolutionKey:(int32_t)resolutionKey height:(SVPFloat * _Nullable)height width:(SVPFloat * _Nullable)width bitrate:(SVPDouble * _Nullable)bitrate dataConsumption:(NSString * _Nullable)dataConsumption __attribute__((swift_name("init(index:value:resolutionKey:height:width:bitrate:dataConsumption:)"))) __attribute__((objc_designated_initializer));
- (SVPVideoQuality *)doCopyIndex:(int32_t)index value:(NSString *)value resolutionKey:(int32_t)resolutionKey height:(SVPFloat * _Nullable)height width:(SVPFloat * _Nullable)width bitrate:(SVPDouble * _Nullable)bitrate dataConsumption:(NSString * _Nullable)dataConsumption __attribute__((swift_name("doCopy(index:value:resolutionKey:height:width:bitrate:dataConsumption:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SVPDouble * _Nullable bitrate __attribute__((swift_name("bitrate")));
@property (readonly) NSString * _Nullable dataConsumption __attribute__((swift_name("dataConsumption")));
@property (readonly) SVPFloat * _Nullable height __attribute__((swift_name("height")));
@property (readonly) int32_t index __attribute__((swift_name("index")));
@property (readonly) int32_t resolutionKey __attribute__((swift_name("resolutionKey")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@property (readonly) SVPFloat * _Nullable width __attribute__((swift_name("width")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ReadableTime")))
@interface SVPReadableTime : SVPBase
- (instancetype)initWithSeconds:(int64_t)seconds minutes:(int64_t)minutes hours:(int64_t)hours __attribute__((swift_name("init(seconds:minutes:hours:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int64_t hours __attribute__((swift_name("hours")));
@property (readonly) int64_t minutes __attribute__((swift_name("minutes")));
@property (readonly) int64_t seconds __attribute__((swift_name("seconds")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface SVPKotlinByteArray : SVPBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(SVPByte *(^)(SVPInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (SVPKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

@interface SVPKotlinByteArray (Extensions)
- (NSData * _Nullable)toNsData __attribute__((swift_name("toNsData()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrmPlayerControllerKt")))
@interface SVPDrmPlayerControllerKt : SVPBase
+ (NSData * _Nullable)requestApplicationCertificateFpsCertificateUrl:(NSString *)fpsCertificateUrl __attribute__((swift_name("requestApplicationCertificate(fpsCertificateUrl:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ExtensionsKt")))
@interface SVPExtensionsKt : SVPBase
+ (id<SVPUiModifier>)noRippleClickable:(id<SVPUiModifier>)receiver onClick:(void (^)(void))onClick __attribute__((swift_name("noRippleClickable(_:onClick:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MainViewControllerKt")))
@interface SVPMainViewControllerKt : SVPBase
+ (UIViewController *)VideoViewControllerVideoPlayerController:(SVPVideoPlayerController *)videoPlayerController videoItem:(SVPVideoItem * _Nullable)videoItem listOfVideoUrls:(NSArray<SVPVideoItem *> * _Nullable)listOfVideoUrls __attribute__((swift_name("VideoViewController(videoPlayerController:videoItem:listOfVideoUrls:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Platform_iosKt")))
@interface SVPPlatform_iosKt : SVPBase
+ (id<SVPPlatform>)getPlatform __attribute__((swift_name("getPlatform()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TimeUtilKt")))
@interface SVPTimeUtilKt : SVPBase
+ (SVPReadableTime *)convertMillisToReadableTimeMillis:(int64_t)millis __attribute__((swift_name("convertMillisToReadableTime(millis:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreFlow")))
@protocol SVPKotlinx_coroutines_coreFlow
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)collectCollector:(id<SVPKotlinx_coroutines_coreFlowCollector>)collector completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("collect(collector:completionHandler:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSharedFlow")))
@protocol SVPKotlinx_coroutines_coreSharedFlow <SVPKotlinx_coroutines_coreFlow>
@required
@property (readonly) NSArray<id> *replayCache __attribute__((swift_name("replayCache")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreStateFlow")))
@protocol SVPKotlinx_coroutines_coreStateFlow <SVPKotlinx_coroutines_coreSharedFlow>
@required
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreFlowCollector")))
@protocol SVPKotlinx_coroutines_coreFlowCollector
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)emitValue:(id _Nullable)value completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("emit(value:completionHandler:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreMutableSharedFlow")))
@protocol SVPKotlinx_coroutines_coreMutableSharedFlow <SVPKotlinx_coroutines_coreSharedFlow, SVPKotlinx_coroutines_coreFlowCollector>
@required

/**
 * @note annotations
 *   kotlinx.coroutines.ExperimentalCoroutinesApi
*/
- (void)resetReplayCache __attribute__((swift_name("resetReplayCache()")));
- (BOOL)tryEmitValue:(id _Nullable)value __attribute__((swift_name("tryEmit(value:)")));
@property (readonly) id<SVPKotlinx_coroutines_coreStateFlow> subscriptionCount __attribute__((swift_name("subscriptionCount")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreMutableStateFlow")))
@protocol SVPKotlinx_coroutines_coreMutableStateFlow <SVPKotlinx_coroutines_coreStateFlow, SVPKotlinx_coroutines_coreMutableSharedFlow>
@required
- (void)setValue:(id _Nullable)value __attribute__((swift_name("setValue(_:)")));
- (BOOL)compareAndSetExpect:(id _Nullable)expect update:(id _Nullable)update __attribute__((swift_name("compareAndSet(expect:update:)")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol SVPKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

__attribute__((swift_name("KotlinByteIterator")))
@interface SVPKotlinByteIterator : SVPBase <SVPKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (SVPByte *)next __attribute__((swift_name("next()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
__attribute__((swift_name("UiModifier")))
@protocol SVPUiModifier
@required
- (BOOL)allPredicate:(SVPBoolean *(^)(id<SVPUiModifierElement>))predicate __attribute__((swift_name("all(predicate:)")));
- (BOOL)anyPredicate:(SVPBoolean *(^)(id<SVPUiModifierElement>))predicate __attribute__((swift_name("any(predicate:)")));
- (id _Nullable)foldInInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<SVPUiModifierElement>))operation __attribute__((swift_name("foldIn(initial:operation:)")));
- (id _Nullable)foldOutInitial:(id _Nullable)initial operation:(id _Nullable (^)(id<SVPUiModifierElement>, id _Nullable))operation __attribute__((swift_name("foldOut(initial:operation:)")));
- (id<SVPUiModifier>)thenOther:(id<SVPUiModifier>)other __attribute__((swift_name("then(other:)")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface SVPKotlinThrowable : SVPBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (SVPKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SVPKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface SVPKotlinException : SVPKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface SVPKotlinRuntimeException : SVPKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface SVPKotlinIllegalStateException : SVPKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface SVPKotlinCancellationException : SVPKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SVPKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("UiModifierElement")))
@protocol SVPUiModifierElement <SVPUiModifier>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface SVPKotlinArray<T> : SVPBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(SVPInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<SVPKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
