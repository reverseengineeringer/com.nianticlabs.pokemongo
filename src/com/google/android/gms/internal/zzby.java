package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

@zzgr
public final class zzby
{
  public static final zzbu<Integer> zzuA = zzbu.zza("gads:video_stream_exo_cache:buffer_size", 8388608);
  public static final zzbu<Long> zzuB = zzbu.zzb("gads:video_stream_cache:limit_time_sec", 300L);
  public static final zzbu<Long> zzuC = zzbu.zzb("gads:video_stream_cache:notify_interval_millis", 1000L);
  public static final zzbu<Integer> zzuD = zzbu.zza("gads:video_stream_cache:connect_timeout_millis", 10000);
  public static final zzbu<Boolean> zzuE = zzbu.zza("gads:video:metric_reporting_enabled", Boolean.valueOf(false));
  public static final zzbu<String> zzuF = zzbu.zzc("gads:video:metric_frame_hash_times", "");
  public static final zzbu<Long> zzuG = zzbu.zzb("gads:video:metric_frame_hash_time_leniency", 500L);
  public static final zzbu<String> zzuH = zzbu.zzQ("gads:spam_ad_id_decorator:experiment_id");
  public static final zzbu<Boolean> zzuI = zzbu.zza("gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
  public static final zzbu<String> zzuJ = zzbu.zzQ("gads:looper_for_gms_client:experiment_id");
  public static final zzbu<Boolean> zzuK = zzbu.zza("gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
  public static final zzbu<Boolean> zzuL = zzbu.zza("gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
  public static final zzbu<Boolean> zzuM = zzbu.zza("gads:sw_dynamite:enabled", Boolean.valueOf(true));
  public static final zzbu<String> zzuN = zzbu.zzc("gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
  public static final zzbu<String> zzuO = zzbu.zzc("gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
  public static final zzbu<String> zzuP = zzbu.zzc("gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
  public static final zzbu<Boolean> zzuQ = zzbu.zza("gads:enabled_sdk_csi", Boolean.valueOf(false));
  public static final zzbu<String> zzuR = zzbu.zzc("gads:sdk_csi_server", "https://csi.gstatic.com/csi");
  public static final zzbu<Boolean> zzuS = zzbu.zza("gads:sdk_csi_write_to_file", Boolean.valueOf(false));
  public static final zzbu<Boolean> zzuT = zzbu.zza("gads:enable_content_fetching", Boolean.valueOf(true));
  public static final zzbu<Integer> zzuU = zzbu.zza("gads:content_length_weight", 1);
  public static final zzbu<Integer> zzuV = zzbu.zza("gads:content_age_weight", 1);
  public static final zzbu<Integer> zzuW = zzbu.zza("gads:min_content_len", 11);
  public static final zzbu<Integer> zzuX = zzbu.zza("gads:fingerprint_number", 10);
  public static final zzbu<Integer> zzuY = zzbu.zza("gads:sleep_sec", 10);
  public static final zzbu<Boolean> zzuZ = zzbu.zza("gad:app_index_enabled", Boolean.valueOf(true));
  public static final zzbu<String> zzuk = zzbu.zzP("gads:sdk_core_experiment_id");
  public static final zzbu<String> zzul = zzbu.zzc("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
  public static final zzbu<Boolean> zzum = zzbu.zza("gads:request_builder:singleton_webview", Boolean.valueOf(false));
  public static final zzbu<String> zzun = zzbu.zzP("gads:request_builder:singleton_webview_experiment_id");
  public static final zzbu<Boolean> zzuo = zzbu.zza("gads:sdk_use_dynamic_module", Boolean.valueOf(false));
  public static final zzbu<String> zzup = zzbu.zzP("gads:sdk_use_dynamic_module_experiment_id");
  public static final zzbu<Boolean> zzuq = zzbu.zza("gads:sdk_crash_report_enabled", Boolean.valueOf(false));
  public static final zzbu<Boolean> zzur = zzbu.zza("gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
  public static final zzbu<Boolean> zzus = zzbu.zza("gads:block_autoclicks", Boolean.valueOf(false));
  public static final zzbu<String> zzut = zzbu.zzP("gads:block_autoclicks_experiment_id");
  public static final zzbu<String> zzuu = zzbu.zzQ("gads:prefetch:experiment_id");
  public static final zzbu<String> zzuv = zzbu.zzP("gads:spam_app_context:experiment_id");
  public static final zzbu<Boolean> zzuw = zzbu.zza("gads:spam_app_context:enabled", Boolean.valueOf(false));
  public static final zzbu<String> zzux = zzbu.zzP("gads:video_stream_cache:experiment_id");
  public static final zzbu<Integer> zzuy = zzbu.zza("gads:video_stream_cache:limit_count", 5);
  public static final zzbu<Integer> zzuz = zzbu.zza("gads:video_stream_cache:limit_space", 8388608);
  public static final zzbu<String> zzva = zzbu.zzP("gads:kitkat_interstitial_workaround:experiment_id");
  public static final zzbu<Boolean> zzvb = zzbu.zza("gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
  public static final zzbu<Boolean> zzvc = zzbu.zza("gads:interstitial_follow_url", Boolean.valueOf(true));
  public static final zzbu<Boolean> zzvd = zzbu.zza("gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
  public static final zzbu<String> zzve = zzbu.zzP("gads:interstitial_follow_url:experiment_id");
  public static final zzbu<Boolean> zzvf = zzbu.zza("gads:analytics_enabled", Boolean.valueOf(true));
  public static final zzbu<Boolean> zzvg = zzbu.zza("gads:ad_key_enabled", Boolean.valueOf(false));
  public static final zzbu<Integer> zzvh = zzbu.zza("gads:webview_cache_version", 0);
  public static final zzbu<String> zzvi = zzbu.zzQ("gads:pan:experiment_id");
  public static final zzbu<String> zzvj = zzbu.zzc("gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
  public static final zzbu<Boolean> zzvk = zzbu.zza("gads:ad_manager_creator:enabled", Boolean.valueOf(true));
  public static final zzbu<Boolean> zzvl = zzbu.zza("gads:log:verbose_enabled", Boolean.valueOf(false));
  public static final zzbu<Boolean> zzvm = zzbu.zza("gads:device_info_caching:enabled", Boolean.valueOf(true));
  public static final zzbu<Long> zzvn = zzbu.zzb("gads:device_info_caching_expiry_ms:expiry", 300000L);
  public static final zzbu<Boolean> zzvo = zzbu.zza("gads:gen204_signals:enabled", Boolean.valueOf(false));
  public static final zzbu<Boolean> zzvp = zzbu.zza("gads:webview:error_reporting_enabled", Boolean.valueOf(false));
  public static final zzbu<Boolean> zzvq = zzbu.zza("gads:adid_reporting:enabled", Boolean.valueOf(false));
  public static final zzbu<Boolean> zzvr = zzbu.zza("gads:request_pkg:enabled", Boolean.valueOf(true));
  public static final zzbu<Boolean> zzvs = zzbu.zza("gads:gmsg:disable_back_button:enabled", Boolean.valueOf(false));
  public static final zzbu<Long> zzvt = zzbu.zzb("gads:network:cache_prediction_duration_s", 300L);
  public static final zzbu<Boolean> zzvu = zzbu.zza("gads:mediation:dynamite_first", Boolean.valueOf(true));
  public static final zzbu<Long> zzvv = zzbu.zzb("gads:ad_loader:timeout_ms", 60000L);
  public static final zzbu<Long> zzvw = zzbu.zzb("gads:rendering:timeout_ms", 60000L);
  public static final zzbu<Boolean> zzvx = zzbu.zza("gads:adshield:enable_adshield_instrumentation", Boolean.valueOf(false));
  public static final zzbu<Boolean> zzvy = zzbu.zza("gads:adid_notification:first_party_check:enabled", Boolean.valueOf(true));
  public static final zzbu<Boolean> zzvz = zzbu.zza("gads:support_screen_shot", Boolean.valueOf(true));
  
  public static void initialize(Context paramContext)
  {
    zzp.zzbE().initialize(paramContext);
  }
  
  public static List<String> zzdf()
  {
    return zzp.zzbD().zzdf();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzby
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */